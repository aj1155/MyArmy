package me.myarmy.api.repository.Impl;

import me.myarmy.api.domain.Company;
import me.myarmy.api.domain.QCompany;
import me.myarmy.api.repository.custom.CompanyRepositoryCustom;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

/**
 * Created by USER on 2017-05-17.
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
}
