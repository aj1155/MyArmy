package me.myarmy.service;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.controller.model.request.UserRequest;
import me.myarmy.api.domain.User;
import me.myarmy.api.service.custom.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Manki Kim on 2017-04-17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void createTest(){
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("김만기");
        userRequest.setPassword("1234");
        userRequest.setEmail("aj1155@naver.com");
        //this.userService.create(userRequest);
    }

    @Test
    public void selectTest(){
       User user = this.userService.findUserByEmail("aj1155@naver.com");
       System.out.println(user);
       assertThat(user).isNotNull();
    }


}
