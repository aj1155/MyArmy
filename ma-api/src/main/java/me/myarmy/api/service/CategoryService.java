package me.myarmy.api.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.DataFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    /* xml 정보 */
    @Autowired
    private DataFrame rootDataFrame;

    /***** 지역별 *****/
    @Cacheable(value="findJobAreaCache", key="#area")
    public List<Object> area(String area) {
        Column geunmujy = this.rootDataFrame.col("geunmujy");
        return Arrays.asList(this.rootDataFrame.filter(geunmujy.contains(area)).toJSON().collect());
    }
    /***** 학력 *****/
    @Cacheable(value="findJobGradeCache", key="#grade")
    public List<Object> grade(String grade){
        Column cjhakryeok = this.rootDataFrame.col("cjhakryeok");
        return Arrays.asList(this.rootDataFrame.filter(cjhakryeok.equalTo(grade)).toJSON().collect());
    }
    /***** 경력 *****/
    @Cacheable(value="findJobExperienceCache", key="#experience")
    public List<Object> experience(String experience){
        Column gyeongryeokGbcdNm = this.rootDataFrame.col("gyeongryeokGbcdNm");
        return Arrays.asList(this.rootDataFrame.filter(gyeongryeokGbcdNm.contains(experience)).toJSON().collect());
    }
    /***** 복지 *****/
    @Cacheable(value="findJobWelfareCache", key="#welfare")
    public List<Object> welfare(String welfare){
        Column bokrihs = this.rootDataFrame.col("bokrihs");
        return Arrays.asList(this.rootDataFrame.filter(bokrihs.contains(welfare)).toJSON().collect());
    }

    /***** 직종별 *****/
    @Cacheable(value="findJobOccupationCache", key="#occupation")
    public List<Object> occupation(String occupation){
        Column eopjongGbcdNm = this.rootDataFrame.col("eopjongGbcdNm");
        return Arrays.asList(this.rootDataFrame.filter(eopjongGbcdNm.contains(occupation)).toJSON().collect());
    }

}
