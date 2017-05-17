package me.myarmy.api.service.Impl;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.controller.model.request.RecruitingRequest;
import me.myarmy.api.domain.Recruiting;
import me.myarmy.api.repository.RecruitingRepository;
import me.myarmy.api.service.custom.RecruitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gain on 2017. 5. 4..
 */
@Service
@Slf4j
public class RecruitingServiceImpl implements RecruitingService {

    @Autowired
    private RecruitingRepository recruitingRepository;

    @Override
    public void createRecruiting(RecruitingRequest recruitingRequest){
        Recruiting recruiting = new Recruiting.RecruitingBuilder()
                .setBokrihs(recruitingRequest.getBokrihs())
                .setCjhakryeok(recruitingRequest.getCjhakryeok())
                .setCyjemokNm(recruitingRequest.getCyjemokNm())
                .setDamdangjaFnm(recruitingRequest.getDamdangjaFnm())
                .setDdeopmuNm(recruitingRequest.getDdeopmuNm())
                .setDdjyeonrakcheoNo(recruitingRequest.getDdjyeonrakcheoNo())
                .setDpyeonrakcheoNo(recruitingRequest.getDpyeonrakcheoNo())
                .setEopcheNm(recruitingRequest.getEopcheNm())
                .setEopjongGbcdNm(recruitingRequest.getEopjongGbcdNm())
                .setGeunmujy(recruitingRequest.getGeunmujy())
                .setGyeongryeokGbcdNm(recruitingRequest.getGyeongryeokGbcdNm())
                .setGyjogeonCdNm(recruitingRequest.getGyjogeonCdNm())
                .setJeopsubb(recruitingRequest.getJeopsubb())
                .setSschaeyongYn(recruitingRequest.getSschaeyongYn())
                .setYeokjongBrcdNm(recruitingRequest.getYeokjongBrcdNm())
                .setYowonGbcdNm(recruitingRequest.getYowonGbcdNm())
                .setMagamDt(recruitingRequest.getMagamDt())
                .build();
        this.recruitingRepository.save(recruiting);
    }
}

