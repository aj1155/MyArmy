package me.myarmy.api.conf;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Manki Kim on 2017-03-04.
 * email : aj1155@naver.com
 */
@Configuration
public class RootRDDConfig {

    @Autowired
    private JavaSparkContext javaSparkContext;

    @Value("${input.file}")
    private String inputFile;

    @Bean
    public DataFrame rootDataFrame() {
        SQLContext sql = new SQLContext(javaSparkContext);

        DataFrame data =
                sql.read().
                        format("com.databricks.spark.xml")
                        .option("rowTag","item")
                        .load(inputFile);
        return data;
    }

}
