package me.myarmy.api.service.custom;

import me.myarmy.api.domain.Company;

/**
 * Created by Manki Kim on 2017-05-16.
 */
public interface CompanyService {

    public Company findByWelfare(String bokrihs);
}
