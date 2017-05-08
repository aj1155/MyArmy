package me.myarmy.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.myarmy.api.controller.model.request.ResumeRequest;
import me.myarmy.api.controller.model.response.MaApiResponse;
import me.myarmy.api.service.custom.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by gain on 2017. 5. 6..
 */
@Api(description = "이력서 api")
@RestController
@RequestMapping(value = "/api/v1/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @ApiOperation(value = "생성", notes = "유저 이력서를 등록합니다.")
    @RequestMapping(method = RequestMethod.POST)
    public MaApiResponse createResume(@Valid @RequestBody ResumeRequest resumeRequest){
        this.resumeService.createResume(resumeRequest);
        return new MaApiResponse(MaApiResponse.OK);
    }

}
