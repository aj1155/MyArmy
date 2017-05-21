package me.myarmy.api.controller;

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
@RestController
@RequestMapping("/api/v1/recommend")
public class RecommendController {

    @Autowired
    private PredictionService predictionService;

    @GetMapping()
    public MaApiResponse<List<CompanyResponse>> getRecommedItems(){
        return new MaApiResponse<>(this.predictionService.predictCompany());
    }

}
