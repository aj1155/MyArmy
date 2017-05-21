package me.myarmy.service;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.service.custom.RecommendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Manki Kim on 2017-05-21.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class RecommendServiceTest {

    @Autowired
    private RecommendService recommendService;

    @Test
    public void setRecommendServiceTest(){
        this.recommendService.recomendCompany();
    }

    @Test
    public void getMaxRatingTest(){
        this.recommendService.getMaxRatingBySql();
    }

    @Test
    public void traingRatingTest(){
        this.recommendService.trainingRating(13);
    }



}
