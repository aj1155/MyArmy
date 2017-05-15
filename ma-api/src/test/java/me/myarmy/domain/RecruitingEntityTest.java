package me.myarmy.domain;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.domain.Recruiting;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by gain on 2017. 5. 4..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class RecruitingEntityTest {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Test
    public void userAndRoleManyToManyTest() {
        Recruiting recruiting = new Recruiting.RecruitingBuilder()
                .setBokrihs("복리후생")
                .setCjhakryeok("대졸이상")
                .setCyjemokNm("산업기능요원 채용")
                .setDamdangjaFnm("이가인")
                .setDdeopmuNm("주조, 검사")
                .setDdjyeonrakcheoNo("010-1234-5667")
                .setDpyeonrakcheoNo("02-1234-5678")
                .setEopcheNm("윈윈")
                .setEopjongGbcdNm("철강")
                .setGeunmujy("서울시 종로구 홍지동")
                .setGyeongryeokGbcdNm("신입")
                .setGyjogeonCdNm("1800")
                .setJeopsubb("이메일, 우편")
                .setMagamDt("20170504")
                .setSschaeyongYn("N")
                .setYeokjongBrcdNm("현역")
                .setYowonGbcdNm("산업기능요원")
                .build();
        this.entityManager.persist(recruiting);

    }

    @Before
    public void setUp() throws Exception {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @After
    public void after() {
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
