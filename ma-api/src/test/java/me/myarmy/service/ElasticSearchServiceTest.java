package me.myarmy.service;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.domain.Company;
import me.myarmy.api.repository.CompanyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Manki Kim on 2017-05-22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class ElasticSearchServiceTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void getAccountTemplateSearchQueryStringQueryTest() {
        List<Company> list = this.companyRepository.findAllContents("철강");
        System.out.println("사이즈"+list.size());
    }
}
