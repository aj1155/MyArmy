package me.myarmy.domain;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.domain.Role;
import me.myarmy.api.domain.User;
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
 * Created by Manki Kim on 2017-04-02.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class UserEntityTest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Test
    public void userAndRoleManyToManyTest() {

        Role role = Role.of("관리자");
        entityManager.persist(role);

        User user = User.of("201232005","1234","김만기","aj1155@naver.com");
        user.addRoles(role);
        entityManager.persist(user);


        Assert.assertEquals(role.getId(), user.getRoles().get(0).getId());
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
