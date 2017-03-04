package me.myarmy.api.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.DataFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Manki Kim on 2017-03-04.
 * email : aj1155@naver.com
 */
@Service
@Slf4j
public class CategoryService {

    @Autowired
    private DataFrame rootDataFrame;

    /***** 지역별 *****/
    public List<Object> area(String area){
        Column geunmujy = rootDataFrame.col("geunmujy");
        return Arrays.asList(rootDataFrame.filter(geunmujy.contains(area)).toJSON().collect());
    }
}
