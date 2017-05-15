package me.myarmy.service;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.controller.model.request.RecruitingRequest;
import me.myarmy.api.service.custom.RecruitingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by gain on 2017. 5. 5..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class RecruitingServiceTest {

    @Autowired
    private RecruitingService recruitingService;

    @Test
    public void createTest(){
        RecruitingRequest recruitingRequest = new RecruitingRequest();
        recruitingRequest.setBokrihs("복리후생");
        recruitingRequest.setCjhakryeok("대졸 이상");
        recruitingRequest.setCyjemokNm("산업기능요원 채용");
        recruitingRequest.setDamdangjaFnm("이가인");
        recruitingRequest.setDdeopmuNm("주조, 검사");
        recruitingRequest.setDdjyeonrakcheoNo("01012345678");
        recruitingRequest.setDpyeonrakcheoNo("0200000000");
        recruitingRequest.setEopcheNm("윈윈");
        recruitingRequest.setEopjongGbcdNm("철강");
        recruitingRequest.setGeunmujy("서울시 종로구 홍지동");
        recruitingRequest.setGyeongryeokGbcdNm("신입");
        recruitingRequest.setGyjogeonCdNm("1800");
        recruitingRequest.setJeopsubb("이메일, 우편");
        recruitingRequest.setMagamDt("20170504");
        recruitingRequest.setSschaeyongYn("N");
        recruitingRequest.setYeokjongBrcdNm("현역");
        recruitingRequest.setYowonGbcdNm("산업기능요원");
        this.recruitingService.createRecruiting(recruitingRequest);
    }
}
