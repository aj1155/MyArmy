package me.myarmy.controller;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.controller.model.request.UserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Manki Kim on 2017-04-17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class UserManageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Test
    public void testUserCreateValid() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("aj1155@naver.com");
        userRequest.setPassword("12341234");
        userRequest.setUsername("김만기");
        Gson gson = new Gson();
        String json = gson.toJson(userRequest);
        MvcResult result = mockMvc.perform(post("/api/v1/manage")
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(1004)))
                .andReturn();

        log.debug("{}", result.getResponse().getContentAsString());
    }
}
