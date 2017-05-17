package me.myarmy.api.service.Impl;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.domain.Company;
import me.myarmy.api.repository.CompanyRepository;
import me.myarmy.api.service.custom.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Manki Kim on 2017-05-16.
 */
@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company findByWelfare(String bokrihs) {
        return this.companyRepository.findOne(1);
    }
}
