package me.myarmy.api.service;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.controller.exception.ResumeNotFoundException;
import me.myarmy.api.controller.model.response.CompanyResponse;
import me.myarmy.api.domain.Company;
import me.myarmy.api.domain.Resume;
import me.myarmy.api.repository.CompanyRepository;
import me.myarmy.api.repository.ResumeRepository;
import me.myarmy.api.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Manki Kim on 2017-03-04.
 * email : aj1155@naver.com
 */
@Service
@Slf4j
public class CategoryService {

    /* xml 정보 */
    /*
    @Autowired
    private DataFrame rootDataFrame;
    */
    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserService userService;

    /*
    @Cacheable(value="findJobAll", key="#all")
    public List<Object> all(String all) {
        Column geunmujy = this.rootDataFrame.col("geunmujy");
        return Arrays.asList(this.rootDataFrame.filter(geunmujy.contains(area)).distinct().toJSON().collect());
    }
    */

     /***** 전체 *****/
    @Cacheable(value="findAll")
    public List<CompanyResponse> all() {
        return convertCompanyEntityToResponse(this.companyRepository.findAll());
    }

    /***** 전체 *****/
    public List<CompanyResponse> allByText(String text) {
        return convertCompanyEntityToResponse(this.companyRepository.findAllContents(text));
    }

    /***** 지역별 *****/
    @Cacheable(value="findJobAreaCache", key="#area")
    public List<CompanyResponse> area(String area) {
        return convertCompanyEntityToResponse(this.companyRepository.findByArea(area));
    }
    /***** 학력 *****/
    @Cacheable(value="findJobGradeCache", key="#grade")
    public List<CompanyResponse> grade(String grade){
        return convertCompanyEntityToResponse(this.companyRepository.findByGrade(grade));
    }
    /***** 경력 *****/
    @Cacheable(value="findJobExperienceCache", key="#experience")
    public List<CompanyResponse> experience(String experience){
        return convertCompanyEntityToResponse(this.companyRepository.findByExperience(experience));
    }
    /***** 복지 *****/
    @Cacheable(value="findJobWelfareCache", key="#welfare")
    public List<CompanyResponse> welfare(String welfare){
        return convertCompanyEntityToResponse(this.companyRepository.findByWelfare(welfare));
    }

    /***** 직종별 *****/
    @Cacheable(value="findJobOccupationCache", key="#occupation")
    public List<CompanyResponse> occupation(String occupation){
        return convertCompanyEntityToResponse(this.companyRepository.findByOccupation(occupation));
    }

    /***** 작성일 최신순 *****/
    @Cacheable(value="findJopCreatedDateCache")
    public List<CompanyResponse> createdDate(){
        return convertCompanyEntityToResponse(this.companyRepository.findByDateDesc());
    }

    /****스마트 매칭****/
    public List<CompanyResponse> smartMatch() throws ResumeNotFoundException {
        Optional<Resume> resumeOptional = Optional.ofNullable(this.resumeRepository.findByUserId(this.userService.findCurrentUserId()));
        if(!resumeOptional.isPresent()){
            throw new ResumeNotFoundException("이력서를 먼저 등록해주세요");
        }else{
            Resume resume = resumeOptional.get();
            List<CompanyResponse> companyResponses = convertCompanyEntityToResponse(this.companyRepository.smartMatch(resume.getGrade(),resume.getObjective(),resume.getAddress()));
            return companyResponses;
        }
    }

    private List<CompanyResponse> convertCompanyEntityToResponse(List<Company> companies){
        List<CompanyResponse> companyResponses = Optional.ofNullable(companies).orElse(Collections.emptyList()).stream()
                .map(company -> CompanyResponse.of(company))
                .collect(Collectors.toList());

        return companyResponses;
    }
}