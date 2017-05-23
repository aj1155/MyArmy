package me.myarmy.service;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.controller.model.request.ResumeRequest;
import me.myarmy.api.domain.Resume;
import me.myarmy.api.repository.ResumeRepository;
import me.myarmy.api.service.custom.ResumeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Autowired
    private ResumeRepository resumeRepository;

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

        Resume result = this.resumeRepository.findByUserId(1);
        assertThat(result).isNotNull();
    }

    @Test
    public void testReadResume() throws Exception{
        Resume result = this.resumeService.readResume();
        assertThat(result).isNotNull();
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
        this.resumeService.createResume(resumeRequest);

        Resume result = this.resumeRepository.findByUserId(1);
        assertThat(result.getObjective()).isEqualTo("기계");
        assertThat(result.getGrade()).isEqualTo("고등학교");
        assertThat(result.getAddress()).isEqualTo("가좌동");
    }
}
