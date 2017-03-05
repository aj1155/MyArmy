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
    public List<Object> area(String area) {
        Column geunmujy = this.rootDataFrame.col("geunmujy");
        return Arrays.asList(this.rootDataFrame.filter(geunmujy.contains(area)).toJSON().collect());
    }
    /***** 학력 *****/
    public List<Object> grade(String grade){
        Column cjhakryeok = this.rootDataFrame.col("cjhakryeok");
        return Arrays.asList(this.rootDataFrame.filter(cjhakryeok.equalTo(grade)).toJSON().collect());
    }
    /***** 경력 *****/
    public List<Object> experience(String experience){
        Column gyeongryeokGbcdNm = this.rootDataFrame.col("gyeongryeokGbcdNm");
        return Arrays.asList(this.rootDataFrame.filter(gyeongryeokGbcdNm.contains(experience)).toJSON().collect());
    }
    /***** 복지 *****/
    public List<Object> welfare(String welfare){
        Column bokrihs = this.rootDataFrame.col("bokrihs");
        return Arrays.asList(this.rootDataFrame.filter(bokrihs.contains(welfare)).toJSON().collect());
    }

    /***** 직종별 *****/
    public List<Object> occupation(String occupation){
        Column eopjongGbcdNm = this.rootDataFrame.col("eopjongGbcdNm");
        return Arrays.asList(this.rootDataFrame.filter(eopjongGbcdNm.contains(occupation)).toJSON().collect());
    }

}
