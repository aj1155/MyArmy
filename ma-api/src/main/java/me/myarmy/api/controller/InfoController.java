package me.myarmy.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.myarmy.api.controller.exception.RestNotFoundTitleException;
import me.myarmy.api.controller.model.response.MaApiResponse;
import me.myarmy.api.domain.Company;
import me.myarmy.api.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Manki Kim on 2017-05-15.
 */
@Api(description = "회사 상세 정보 API")
@RestController
@RequestMapping("/api/v1/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    /***** 회사 상세 정보 *****/
    @ApiOperation(value = "파라미터 회사 ID(PRIMARY 값)", notes = "회사 상세 정보")
    @GetMapping("/{id}")
    public MaApiResponse<Company> companyDetails(@PathVariable String id)  {
        return new MaApiResponse<>(this.infoService.getCompanyDetails(Integer.parseInt(id)));
    }

    /***** 썸네일 정보 *****/
    @ApiOperation(value = "파라미터 회사 ID(PRIMARY 값)", notes = "썸네일 정보")
    @GetMapping("/thumbnail/{id}")
    public MaApiResponse thumbUrl(@PathVariable String id) throws RestNotFoundTitleException {
        return new MaApiResponse<>(this.infoService.getThumbUrl(Integer.parseInt(id)));
    }

    @ExceptionHandler(RestNotFoundTitleException.class)
    public MaApiResponse handleUserNotFound(RestNotFoundTitleException exc) {
        return new MaApiResponse(MaApiResponse.NOT_FOUND);
    }
}
