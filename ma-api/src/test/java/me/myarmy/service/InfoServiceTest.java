package me.myarmy.service;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.service.InfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Manki Kim on 2017-05-15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class InfoServiceTest {

    @Autowired
    private InfoService infoService;

    @Test
    public void getThumbUrl(){
        String s = this.infoService.getHmpg("2000000035039");
        assertThat(s).isNotNull();
    }
}
