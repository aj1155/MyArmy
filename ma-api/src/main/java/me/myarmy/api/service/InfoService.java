package me.myarmy.api.service;

import me.myarmy.api.controller.exception.RestNotFoundTitleException;
import me.myarmy.api.domain.Company;
import me.myarmy.api.domain.User;
import me.myarmy.api.domain.UserFavor;
import me.myarmy.api.repository.CompanyRepository;
import me.myarmy.api.repository.UserFavorRepository;
import me.myarmy.api.repository.UserRepository;
import org.apache.spark.sql.DataFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private UserRepository userRepository;

    public String getThumbUrl(int id) throws RestNotFoundTitleException {
        return this.restService.getThumb(getHmpg(id));
    }

    public String getHmpg(int id){
        Company company = this.companyRepository.findOne(id);
        return company.getHmpgAddr();
    }

    public Company getCompanyDetails(int id) {
        Company company = this.companyRepository.findOne(id);
        memorizeUserFavor(id);
        return company;
    }

    private void memorizeUserFavor(int companyId){
        Company company = this.companyRepository.findOne(companyId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = this.userRepository.findByEmail(email);
        UserFavor userFavor = UserFavor.of(company.getId(),user.getId(),company.getBokrihs(),company.getCjhakryeok(),company.getEopjongGbcdNm(),company.getGeunmujysido());
        this.userFavorRepository.save(userFavor);
    }
}
