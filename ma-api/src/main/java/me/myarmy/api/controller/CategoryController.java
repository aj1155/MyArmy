package me.myarmy.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.myarmy.api.controller.model.response.MaApiResponse;
import me.myarmy.api.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Api(description = "회사 리스트 카테고리별 분류 API")
@RestController
@EnableCaching
@RequestMapping("/api/v1/category")
public class CategoryController {

    private static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    /***** 지역별 *****/
    @ApiOperation(value = "지역명", notes = "지역별 회사 리스트를 가져옵니다.")
    @GetMapping("/area/{area}")
    public MaApiResponse<List<Object>> disArea(@PathVariable String area){

        List<Object> list = this.categoryService.area(area);
        return new MaApiResponse<>(list);
    }

    /***** 학력 *****/
    @ApiOperation(value = "최종학력", notes = "학력별 회사 리스트를 가져옵니다.")
    @GetMapping("/grade/{grade}")
    public MaApiResponse<List<Object>> disGrade(@PathVariable String grade){
        List<Object> list = this.categoryService.grade(grade);
        return new MaApiResponse<>(list);
    }

    /***** 경력 *****/
    @ApiOperation(value = "경력명", notes = "경력별 회사 리스트를 가져옵니다.")
    @GetMapping("/experience/{experience}")
    public MaApiResponse<List<Object>> disExp(@PathVariable String experience){
        List<Object> list = this.categoryService.experience(experience);
        return new MaApiResponse<>(list);
    }

    /***** 복지 *****/
    @ApiOperation(value = "복지명", notes = "해당 복지별 회사 리스트를 가져옵니다.")
    @GetMapping("/welfare/{welfare}")
    public MaApiResponse<List<Object>> disWelfare(@PathVariable String welfare){
        List<Object> list = this.categoryService.welfare(welfare);
        return new MaApiResponse<>(list);
    }

    /***** 직종 *****/
    @ApiOperation(value = "직종명", notes = "직종별 회사 리스트를 가져옵니다.")
    @GetMapping("/occupation/{occupation}")
    public MaApiResponse<List<Object>> disOccupation(@PathVariable String occupation){
        List<Object> list = this.categoryService.occupation(occupation);
        return new MaApiResponse<>(list);
    }

    @ApiOperation(value = "작성일", notes = "작성일 순서대로 회사 리스트를 가져옵니다.")
    @GetMapping("/createdDate")
    public MaApiResponse<List<Object>> disCreatedDate(){
        List<Object> list = this.categoryService.createdDate();
        return new MaApiResponse<>(list);
    }
}
