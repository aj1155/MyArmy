package me.myarmy.service;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.domain.Company;
import me.myarmy.api.service.custom.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Manki Kim on 2017-05-16.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;

    @Test
    public void welTest() {
        Company result = this.companyService.findByWelfare("aa");
        System.out.println(result);
        assertThat(result).isNotNull();
    }
}