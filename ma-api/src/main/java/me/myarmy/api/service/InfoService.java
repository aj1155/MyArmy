package me.myarmy.api.service;

import me.myarmy.api.controller.exception.RestNotFoundTitleException;
import me.myarmy.api.domain.Company;
import me.myarmy.api.domain.UserFavor;
import me.myarmy.api.repository.CompanyRepository;
import me.myarmy.api.repository.UserFavorRepository;
import org.apache.spark.sql.DataFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Manki KIM on 2017-05-15.
 */
@Service
public class InfoService {

    @Autowired
    private DataFrame rootDataFrame;

    @Autowired
    private RestService restService;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserFavorRepository userFavorRepository;

    public String getThumbUrl(int id) throws RestNotFoundTitleException {
        return this.restService.getThumb(getHmpg(id));
    }

    public String getHmpg(int id){
        Company company = this.companyRepository.findOne(id);
        return company.getHmpgAddr();
    }

    public Company getCompanyDetails(int id) {
        Company company = this.companyRepository.findOne(id);
        UserFavor userFavor = UserFavor.of(company.getBokrihs(),company.getCjhakryeok(),company.getEopjongGbcdNm(),company.getGeunmujysido());
        this.userFavorRepository.save(userFavor);
        return company;
    }
}
