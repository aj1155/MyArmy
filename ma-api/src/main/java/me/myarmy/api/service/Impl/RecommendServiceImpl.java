package me.myarmy.api.service.Impl;

import me.myarmy.api.domain.Company;
import me.myarmy.api.domain.Predict;
import me.myarmy.api.domain.User;
import me.myarmy.api.repository.PredictRepository;
import me.myarmy.api.service.custom.RecommendService;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.mllib.recommendation.ALS;
import org.apache.spark.mllib.recommendation.MatrixFactorizationModel;
import org.apache.spark.mllib.recommendation.Rating;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * Created by Manki Kim on 2017-05-21.
 */
@Service
public class RecommendServiceImpl implements RecommendService{


    @Autowired
    private PredictRepository predictRepository;

    @Autowired
    private DataFrame userFavorFrame;

    @Autowired
    private DataFrame userFrame;

    @Autowired
    private DataFrame companyFrame;

    @Autowired
    private SQLContext sqlContext;

    @Override
    public JavaRDD<User> getUserRDD() {
        JavaRDD<User> userRDD = this.userFrame.javaRDD().map(row -> {
            Long id =  Long.parseLong(row.getAs("id").toString());
            String userName = row.getAs("user_name").toString();
            String email = row.getAs("email").toString();
            return User.ofUpdate(id,null,null,userName,email);
        }).cache();
        return userRDD;
    }

    @Override
    public JavaRDD<Company> getCompanyRDD() {
        JavaRDD<Company> companyRDD = this.companyFrame.javaRDD().map(row -> {
            Company company = new Company();
            company.setId(Integer.parseInt(row.getAs("id").toString()));
            company.setBokrihs(row.getAs("bokrihs").toString());
            company.setCcdatabalsaengDtm(row.getAs("ccdatabalsaengdtm").toString());
            company.setCjdatabyeongyeongDtm(row.getAs("cjdatabyeongyeongdtm").toString());
            company.setCjhakryeok(row.getAs("cjhakryeok").toString());
            company.setDdeopmuNm(row.getAs("ddeopmunm").toString());
            company.setEopcheNm(row.getAs("eopchenm").toString());
            company.setEopjongGbcd(row.getAs("eopjonggbcd").toString());
            company.setEopjongGbcdNm(row.getAs("eopjonggbcdnm").toString());
            company.setGeunmujy(row.getAs("geunmujy").toString());
            company.setGeunmujysido(row.getAs("geunmujysido"));
            return company;
        }).cache();
        return companyRDD;
    }

    @Override
    public JavaRDD<Rating> getUserFavorRDD() {
        JavaRDD<Rating> userFavorRDD = this.userFavorFrame.javaRDD().map(row -> {
            Long userId = Long.parseLong(row.getAs("user_id").toString());
            Integer companyId = Integer.parseInt(row.getAs("company_id").toString());
            Integer rating = Integer.parseInt(row.getAs("rating").toString());
            return new Rating(userId.intValue(),companyId,rating.doubleValue());
        }).cache();
        return userFavorRDD;
    }

    @Override
    public void recomendCompany() {
        JavaRDD<Rating> userFavorRDD = getUserFavorRDD();
        userFrame.printSchema();
        //JavaPairRDD<Integer, Iterable<UserFavor>> ratingsGroupByCompant = userFavorRDD.groupBy(UserFavor::getCompanyId);
        //ratingsGroupByCompant.collect().forEach(System.out::println);
    }

    @Override
    public void getMaxRatingBySql(){
        StructType structType = new StructType(new StructField[]{DataTypes.createStructField("user", DataTypes.IntegerType, true),
                DataTypes.createStructField("company", DataTypes.IntegerType, true),
                DataTypes.createStructField("rating", DataTypes.DoubleType, true)});

        JavaRDD<Row> ratingRowRdd = getUserFavorRDD().map(row -> {
            return new RowFactory().create(row.user(),row.product() ,row.rating());
        });


        DataFrame usersDF = this.sqlContext.createDataFrame(getUserRDD(), User.class);
        usersDF.registerTempTable("user");
        DataFrame ratingDF = this.sqlContext.createDataFrame(ratingRowRdd, structType);
        ratingDF.registerTempTable("ratings");
        DataFrame companyDF = this.sqlContext.createDataFrame(getCompanyRDD(),Company.class);
        companyDF.registerTempTable("company");

        /***
         * user 별 가장 많이 참조한 회사 max 10개만
         */
        DataFrame top10MostActive = sqlContext.sql("SELECT ratings.user, count(*) as ct from ratings group by ratings.user order by ct desc limit 10");

        for(Row row : top10MostActive.collectAsList()){
            System.out.println("row:"+row);
        }

        /***
         * userId 13인 유저가 가장 많이 참조한 회사
         */
        DataFrame idUser13 = sqlContext.sql("SELECT ratings.user, ratings.company,ratings.rating, company.eopcheNm FROM ratings JOIN company ON company.id=ratings.company"
                + " where ratings.user=13 and ratings.rating > 1");

        idUser13.show();

    }

    @Override
    public void trainingRating(long userId) {
        JavaRDD<User> userRDD = getUserRDD();
        JavaRDD<Company> companyRDD = getCompanyRDD();
        JavaRDD<Rating> trainingRatingRDD = getUserFavorRDD();

        ALS als = new ALS();
        MatrixFactorizationModel model = als.setRank(20).setIterations(10).run(trainingRatingRDD);
        Optional<Rating[]> optionalRating = Optional.ofNullable(model.recommendProducts((int) userId, 4));
        if(!optionalRating.isPresent()){
            return;
        }
        Rating[] recommendeds = optionalRating.get();
        StringBuilder idText = new StringBuilder();
        System.out.println("Recommendations for 17");
        for (Rating ratings : recommendeds) {
            idText.append(ratings.product()).append(",");
            System.out.println("Product id : " + ratings.product() + "-- Rating : " + ratings.rating());
        }
        idText.deleteCharAt(idText.length()-1);
        /*결과 저장*/
        Optional<Predict> predict = Optional.ofNullable(this.predictRepository.findByUserId(userId));
        Predict result;
        if(predict.isPresent()){
            result = new Predict();
            result.setId(predict.get().getId());
            result.setCompanyIdText(idText.toString());
            result.setUserId(userId);
        }else{
            result = new Predict();
            result.setCompanyIdText(idText.toString());
            result.setUserId(userId);
        }

        this.predictRepository.save(result);
    }
}
