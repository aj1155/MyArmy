package me.myarmy.service;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.controller.model.request.ResumeRequest;
import me.myarmy.api.service.custom.ResumeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by gain on 2017. 5. 15..
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class ResumeServiceTest {

    @Autowired
    private ResumeService resumeService;

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
        this.resumeService.createResume(resumeRequest);
    }
}
