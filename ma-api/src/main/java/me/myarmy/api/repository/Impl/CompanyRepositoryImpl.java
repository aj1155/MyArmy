package me.myarmy.api.repository.Impl;

import com.querydsl.core.BooleanBuilder;
import me.myarmy.api.domain.Company;
import me.myarmy.api.domain.QCompany;
import me.myarmy.api.repository.custom.CompanyRepositoryCustom;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

/**
 * Created by Manki Kim on 2017-05-17.
 */
public class CompanyRepositoryImpl extends QueryDslRepositorySupport implements CompanyRepositoryCustom {

    QCompany qCompany = QCompany.company;

    public CompanyRepositoryImpl(){
        super(Company.class);
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
        BooleanBuilder whereClause = new BooleanBuilder();
        whereClause.or(qCompany.cjhakryeok.contains(text));
        whereClause.or(qCompany.eopjongGbcdNm.contains(text));
        whereClause.or(qCompany.geunmujy.contains(text));
        whereClause.or(qCompany.bokrihs.contains(text));
        whereClause.or(qCompany.cyjemoknm.contains(text));
        return from(qCompany)
                .where(whereClause)
                .fetch();
    }

}
