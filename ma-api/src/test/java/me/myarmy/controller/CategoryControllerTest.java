package me.myarmy.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Manki Kim on 2017-04-02.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${test.token}")
    private String token;

    @Test
    public void testDisArea() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/category/area/서울")
                .header("x-auth-token",token)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andReturn();

        log.debug("{}", result.getResponse().getContentAsString());
    }

    @Test
    public void testDisGrade() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/category/grade/고등학교 졸업 ")
                .header("x-auth-token",token)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andReturn();

        log.debug("{}", result.getResponse().getContentAsString());
    }

    @Test
    public void testDisExperience() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/category/experience/무관")
                .header("x-auth-token",token)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andReturn();

        log.debug("{}", result.getResponse().getContentAsString());
    }

    @Test
    public void testDisWelfare() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/category/welfare/퇴직금")
                .header("x-auth-token",token)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andReturn();

        log.debug("{}", result.getResponse().getContentAsString());
    }

    @Test
    public void testDisOccupation() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/category/occupation/철강")
                .header("x-auth-token",token)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andReturn();

        log.debug("{}", result.getResponse().getContentAsString());
    }
}
