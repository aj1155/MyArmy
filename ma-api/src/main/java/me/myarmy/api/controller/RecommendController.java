package me.myarmy.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.myarmy.api.controller.model.response.CompanyResponse;
import me.myarmy.api.controller.model.response.MaApiResponse;
import me.myarmy.api.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Manki kim on 2017-05-21.
 */
@Api(description ="추천 시스템 개발 API")
@RestController
@RequestMapping("/api/v1/recommend")
public class RecommendController {

    @Autowired
    private PredictionService predictionService;

    @ApiOperation(value = "파라미터 없음", notes = "해당 user Id로 최대 4개의 회사 추천")
    @GetMapping()
    public MaApiResponse<List<CompanyResponse>> getRecommedItems(){
        return new MaApiResponse<>(this.predictionService.predictCompany());
    }

}
