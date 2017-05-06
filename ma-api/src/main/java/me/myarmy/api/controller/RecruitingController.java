package me.myarmy.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.myarmy.api.controller.model.request.RecruitingRequest;
import me.myarmy.api.controller.model.response.MaApiResponse;
import me.myarmy.api.service.custom.RecruitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by gain on 2017. 5. 4..
 */

@Api(description = "회사 정보 api")
@RestController
@RequestMapping(value = "/api/v1/recruiting")
public class RecruitingController  {

    @Autowired
    private RecruitingService recruitingService;

    @ApiOperation(value = "생성", notes = "회사 정보를 등록합니다.")
    @PostMapping()
    public MaApiResponse createRecruiting(@Valid @RequestBody RecruitingRequest recruitingRequest){
        this.recruitingService.createRecruiting(recruitingRequest);
        return new MaApiResponse(MaApiResponse.OK);
    }
}
