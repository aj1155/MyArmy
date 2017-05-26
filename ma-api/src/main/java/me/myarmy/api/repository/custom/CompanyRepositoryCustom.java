package me.myarmy.api.repository.custom;

import me.myarmy.api.domain.Company;

import java.util.List;

/**
 * Created by Manki Kim on 2017-02-23.
 */
public interface CompanyRepositoryCustom {

    List<Company> findByWelfare(String welfare);
    List<Company> findByArea(String area);
    List<Company> findByGrade(String grade);
    List<Company> findByExperience(String experience);
    List<Company> findByOccupation(String occupation);
    List<Company> findByDateDesc();
    List<Company> smartMatch(String cjhakryeok,String eopjongGbcdNm,String geunmujy);
    List<Company> findAllContents(String text);
}
