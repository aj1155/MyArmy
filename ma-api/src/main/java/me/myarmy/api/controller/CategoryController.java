package me.myarmy.api.controller;

import me.myarmy.api.controller.model.response.MaApiResponse;
import me.myarmy.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Manki Kim on 2017-03-04.
 * email : aj1155@naver.com
 */
@RestController
@EnableCaching
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /***** 지역별 *****/
    @GetMapping("/area/{area}")
    public MaApiResponse<List<Object>> disArea(@PathVariable String area){
        List<Object> list = this.categoryService.area(area);
        return new MaApiResponse<>(list);
    }

    /***** 학력 *****/
    @GetMapping("/grade/{grade}")
    public MaApiResponse<List<Object>> disGrade(@PathVariable String grade){
        List<Object> list = this.categoryService.grade(grade);
        return new MaApiResponse<>(list);
    }

    /***** 경력 *****/
    @GetMapping("/experience/{experience}")
    public MaApiResponse<List<Object>> disExp(@PathVariable String experience){
        List<Object> list = this.categoryService.experience(experience);
        return new MaApiResponse<>(list);
    }

    /***** 복지 *****/
    @GetMapping("/welfare/{welfare}")
    public MaApiResponse<List<Object>> disWelfare(@PathVariable String welfare){
        List<Object> list = this.categoryService.welfare(welfare);
        return new MaApiResponse<>(list);
    }

    /***** 직종 *****/
    @GetMapping("/occupation/{occupation}")
    public MaApiResponse<List<Object>> disOccupation(@PathVariable String occupation){
        List<Object> list = this.categoryService.occupation(occupation);
        return new MaApiResponse<>(list);
    }

}
