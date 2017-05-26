package me.myarmy.service;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.domain.Company;
import me.myarmy.api.domain.User;
import me.myarmy.api.repository.CompanyRepository;
import me.myarmy.api.repository.UserRepository;
import me.myarmy.api.service.custom.RecommendService;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecommendService recommendService;

    /***
     * 결과적으로 batch 서비스로 변경 해야 함
     */
    @Test
    public void predictCompany(){
        List<User> users = this.userRepository.findAll();
        for(User user : users){
            this.recommendService.trainingRating(user.getId());
        }
    }

    @Test
    public void getAccountTemplateSearchQueryStringQueryTest() {
        List<Company> list = this.companyRepository.findAllContents("철강");
        System.out.println("사이즈"+list.size());
    }
}
