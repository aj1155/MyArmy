package me.myarmy.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.myarmy.api.controller.exception.ResumeNotFoundException;
import me.myarmy.api.controller.model.request.ResumeRequest;
import me.myarmy.api.controller.model.response.MaApiResponse;
import me.myarmy.api.domain.Resume;
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
    public MaApiResponse createResume(@Valid @RequestBody ResumeRequest resumeRequest) throws Exception{
        this.resumeService.createResume(resumeRequest);
        return new MaApiResponse(MaApiResponse.OK);
    }

    @ApiOperation(value = "조회", notes = "세션에 저장된 본인 id로 등록된 이력서를 조회합니다.")
    @RequestMapping(method = RequestMethod.GET)
    public MaApiResponse<Resume> readResume() throws ResumeNotFoundException{
        Resume resume = this.resumeService.readResume();
        return new MaApiResponse<>(resume);
    }

    @ApiOperation(value = "수정", notes = "유저 이력서를 수정합니다.")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public MaApiResponse updateResume(@Valid @RequestBody ResumeRequest resumeRequest){
        this.resumeService.updateResume(resumeRequest);
        return new MaApiResponse(MaApiResponse.OK);
    }

    @RequestMapping(value = "/delete")
    public MaApiResponse deleteResume() throws ResumeNotFoundException{
        this.resumeService.deleteResume();
        return new MaApiResponse(MaApiResponse.OK);
    }

    @ExceptionHandler(ResumeNotFoundException.class)
    public MaApiResponse handleResumeNotFound(ResumeNotFoundException exc) {
        return new MaApiResponse(MaApiResponse.NOT_FOUND,"이력서를 등록해주세요");
    }
}
