package me.myarmy.api.repository;

import me.myarmy.api.domain.Company;
import me.myarmy.api.repository.custom.CompanyRepositoryCustom;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Manki Kim on 2017-05-16.
 */
@Repository
public interface CompanyRepository extends ElasticsearchRepository<Company, Integer>,CompanyRepositoryCustom {
}
