package me.myarmy.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
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
        //ecruiting recruiting = Recruiting.of("복리후생", "대졸 이상", "산업기능요원 채용", "이가인", "주조, 검사", "010-1234-5678", "02-1234-5678", "엔아이비", "철강", "서울시 종로구 홍지동", "신입", "1800", "이메일, 우편", "20170504", "N", "현역", "산업기능요원");
        //this.entityManager.persist(recruiting);

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
