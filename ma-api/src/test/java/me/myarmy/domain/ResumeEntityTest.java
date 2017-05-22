package me.myarmy.domain;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.domain.Resume;
import me.myarmy.api.repository.ResumeRepository;
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
 * Created by gain on 2017. 5. 15..
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class ResumeEntityTest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Autowired
    private ResumeRepository resumeRepository;

    @Test
    public void resumeTest(){
        Resume createResume = Resume.of(1, "철강", "영어", "컴퓨터활용능력 1급", "대졸", "서울시 종로구 홍지동", "기타경력사항");
        this.entityManager.persist(createResume);
        Resume findResume = this.resumeRepository.findByUserId(1);

        Assert.assertEquals(createResume.getUserId(), findResume.getUserId());
        Assert.assertEquals(createResume.getObjective(), findResume.getObjective());
        Assert.assertEquals(createResume.getSpecialty(), findResume.getSpecialty());
        Assert.assertEquals(createResume.getLicense(), findResume.getLicense());
        Assert.assertEquals(createResume.getGrade(), findResume.getGrade());
        Assert.assertEquals(createResume.getAddress(), findResume.getAddress());
        Assert.assertEquals(createResume.getMiscellaneous(), findResume.getMiscellaneous());
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
