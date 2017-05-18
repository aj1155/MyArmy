package me.myarmy.api.service.custom;

import me.myarmy.api.domain.Company;

import java.util.List;

/**
 * Created by Manki Kim on 2017-05-16.
 */
public interface CompanyService {

    public List<Company> findByWelfare(String bokrihs);
}
