package me.myarmy.controller;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.controller.model.request.ResumeRequest;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by gain on 2017. 5. 15..
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class ResumeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${test.token}")
    private String token;

    @Test
    public void testCreateResume() throws Exception{
        ResumeRequest resumeRequest = new ResumeRequest();
        resumeRequest.setUid(1);
        resumeRequest.setGrade("대졸");
        resumeRequest.setObjective("철강");
        resumeRequest.setLicense("컴퓨터활용능력 1급");
        resumeRequest.setSpecialty("영어");
        resumeRequest.setAddress("서울시 종로구 홍지동");
        resumeRequest.setMiscellaneous("기타경력사항");

        Gson gson = new Gson();
        String json = gson.toJson(resumeRequest);
        MvcResult result = mockMvc.perform(post("/api/v1/resume")
                .header("x-auth-token",token)
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andReturn();

        log.debug("{}", result.getResponse().getContentAsString());

    }

    @Test
    public void testReadResume() throws Exception{
        MvcResult result = mockMvc.perform(get("/api/v1/resume")
                .header("x-auth-token",token)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andReturn();

        log.debug("{}", result.getResponse().getContentAsString());
    }

    @Test
    public void testUpdateResume() throws Exception{
        ResumeRequest resumeRequest = new ResumeRequest();
        resumeRequest.setUid(1);
        resumeRequest.setGrade("고등학교");
        resumeRequest.setObjective("기계");
        resumeRequest.setLicense("컴퓨터활용능력 1급");
        resumeRequest.setSpecialty("영어");
        resumeRequest.setAddress("가좌동");
        resumeRequest.setMiscellaneous("기타경력사항");

        Gson gson = new Gson();
        String json = gson.toJson(resumeRequest);
        MvcResult result = mockMvc.perform(post("/api/v1/resume")
                .header("x-auth-token",token)
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andReturn();

        log.debug("{}", result.getResponse().getContentAsString());

    }

}
