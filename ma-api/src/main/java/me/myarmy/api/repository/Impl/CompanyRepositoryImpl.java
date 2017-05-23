package me.myarmy.api.repository.Impl;

import com.querydsl.core.BooleanBuilder;
import me.myarmy.api.domain.Company;
import me.myarmy.api.domain.QCompany;
import me.myarmy.api.repository.custom.CompanyRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

/**
 * Created by Manki Kim on 2017-05-17.
 */
public class CompanyRepositoryImpl extends QueryDslRepositorySupport implements CompanyRepositoryCustom {

    QCompany qCompany = QCompany.company;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    public CompanyRepositoryImpl(){
        super(Company.class);
    }


    @Override
    public List<Company> findAll() {
        return from(qCompany)
                .fetch();
    }

    @Override
    public List<Company> findByWelfare(String welfare) {
        return from(qCompany)
                .where(qCompany.bokrihs.contains(welfare))
                .fetch();
    }

    @Override
    public List<Company> findByArea(String area) {
        return from(qCompany)
                .where(qCompany.geunmujysido.contains(area))
                .fetch();
    }

    @Override
    public List<Company> findByGrade(String grade) {
        return from(qCompany)
                .where(qCompany.cjhakryeok.contains(grade))
                .fetch();
    }

    @Override
    public List<Company> findByExperience(String experience) {
        return from(qCompany)
                .where(qCompany.gyeongryeokGbcdNm.contains(experience))
                .fetch();
    }

    @Override
    public List<Company> findByOccupation(String occupation) {
        return from(qCompany)
                .where(qCompany.eopjongGbcdNm.contains(occupation))
                .fetch();
    }

    @Override
    public List<Company> findByDateDesc() {
        return from(qCompany)
                .orderBy(qCompany.ccdatabalsaengDtm.desc())
                .fetch();
    }

    @Override
    public List<Company> smartMatch(String cjhakryeok, String eopjongGbcdNm, String geunmujy) {
        BooleanBuilder whereClause = new BooleanBuilder();
        whereClause.and(qCompany.cjhakryeok.contains(cjhakryeok));
        whereClause.and(qCompany.eopjongGbcdNm.contains(eopjongGbcdNm));
        whereClause.and(qCompany.geunmujy.contains(geunmujy));
        return from(qCompany)
                .where(whereClause)
                .fetch();
    }

    @Override
    public List<Company> findAllContents(String text) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryStringQuery("*"+text+"*")).build();
        List<Company> accounts = this.elasticsearchTemplate.queryForList(searchQuery, Company.class);
        return accounts;
    }

}
