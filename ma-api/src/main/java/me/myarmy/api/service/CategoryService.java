package me.myarmy.api.service;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.domain.Company;
import me.myarmy.api.domain.Resume;
import me.myarmy.api.repository.CompanyRepository;
import me.myarmy.api.repository.ResumeRepository;
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

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    /*
    @Cacheable(value="findJobAll", key="#all")
    public List<Object> all(String all) {
        Column geunmujy = this.rootDataFrame.col("geunmujy");
        return Arrays.asList(this.rootDataFrame.filter(geunmujy.contains(area)).distinct().toJSON().collect());
    }
    /*

     /***** 전체 *****/
    @Cacheable(value="findJobAll", key="#all")
    public List<Company> all(String all) {
        return this.companyRepository.findAll();
    }

    /***** 지역별 *****/
    @Cacheable(value="findJobAreaCache", key="#area")
    public List<Company> area(String area) {
        return this.companyRepository.findByArea(area);
    }
    /***** 학력 *****/
    @Cacheable(value="findJobGradeCache", key="#grade")
    public List<Company> grade(String grade){
        return this.companyRepository.findByGrade(grade);
    }
    /***** 경력 *****/
    @Cacheable(value="findJobExperienceCache", key="#experience")
    public List<Company> experience(String experience){
        return this.companyRepository.findByExperience(experience);
    }
    /***** 복지 *****/
    @Cacheable(value="findJobWelfareCache", key="#welfare")
    public List<Company> welfare(String welfare){
        return this.companyRepository.findByWelfare(welfare);
    }

    /***** 직종별 *****/
    @Cacheable(value="findJobOccupationCache", key="#occupation")
    public List<Company> occupation(String occupation){
        return this.companyRepository.findByOccupation(occupation);
    }

    /***** 작성일 최신순 *****/
    @Cacheable(value="findJopCreatedDateCache")
    public List<Company> createdDate(){
        return this.companyRepository.findByDateDesc();
    }

    /****스마트 매칭****/
    public List<Object> smartMatch(String uid){
        log.debug(uid);
        Resume resume = this.resumeRepository.findByUid(uid);
        log.debug(resume.getObjective());
        log.debug(resume.getAddress());
        Column cjhakryeok = this.rootDataFrame.col("cjhakryeok");
        Column eopjongGbcdNm = this.rootDataFrame.col("eopjongGbcdNm");
        Column geunmujy = this.rootDataFrame.col("geunmujy");


        return Arrays.asList(this.rootDataFrame.filter(cjhakryeok.contains(resume.getGrade())).filter(eopjongGbcdNm.contains(resume.getObjective())).filter(geunmujy.contains(resume.getAddress())).toJSON().collect());
    }
}
