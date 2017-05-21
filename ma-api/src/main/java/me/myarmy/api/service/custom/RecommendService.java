package me.myarmy.api.service.custom;

import me.myarmy.api.domain.Company;
import me.myarmy.api.domain.User;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.mllib.recommendation.Rating;

/**
 * Created by Manki Kim on 2017-05-21.
 */
public interface RecommendService {

    public JavaRDD<User> getUserRDD();
    public JavaRDD<Company> getCompanyRDD();
    public JavaRDD<Rating> getUserFavorRDD();
    public void recomendCompany();
    public void getMaxRatingBySql();
    public void trainingRating(long userId);
}
