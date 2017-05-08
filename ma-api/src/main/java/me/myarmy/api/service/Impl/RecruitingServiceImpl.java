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
        Recruiting recruiting = Recruiting.of(recruitingRequest.getUid(), recruitingRequest.getBokrihs(), recruitingRequest.getCjhakryeok(), recruitingRequest.getCyjemokNm(),
                recruitingRequest.getDamdangjaFnm(), recruitingRequest.getDdeopmuNm(), recruitingRequest.getDdjyeonrakcheoNo(),
                recruitingRequest.getDpyeonrakcheoNo(), recruitingRequest.getEopcheNm(), recruitingRequest.getEopjongGbcdNm(),
                recruitingRequest.getGeunmujy(), recruitingRequest.getGyeongryeokGbcdNm(), recruitingRequest.getGyjogeonCdNm(),
                recruitingRequest.getJeopsubb(), recruitingRequest.getMagamDt(), recruitingRequest.getYeokjongBrcdNm(),
                recruitingRequest.getSschaeyongYn(), recruitingRequest.getYowonGbcdNm());
        this.recruitingRepository.save(recruiting);
    }
}

