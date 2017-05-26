package me.myarmy.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.myarmy.api.controller.exception.ResumeNotFoundException;
import me.myarmy.api.controller.model.response.CompanyResponse;
import me.myarmy.api.controller.model.response.MaApiResponse;
import me.myarmy.api.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

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

    /***** 전체 *****/
    /*
    @ApiOperation(value = "없음", notes = "전체 리스트")
    @GetMapping()
    public MaApiResponse<List<CompanyResponse>> findAll(){

        List<CompanyResponse> list = this.categoryService.all();
        return new MaApiResponse<>(list);
    }
    */
    /***** 전체 *****/
    @ApiOperation(value = "검색 텍스트", notes = "전체 리스트")
    @GetMapping("/all/{text}")
    public MaApiResponse<List<CompanyResponse>> findAllText(@PathVariable String text){

        List<CompanyResponse> list = this.categoryService.allByText(text);
        return new MaApiResponse<>(list);
    }

    /***** 지역별 *****/
    @ApiOperation(value = "지역명", notes = "지역별 회사 리스트를 가져옵니다.")
    @GetMapping("/area/{area}")
    public MaApiResponse<List<CompanyResponse>> disArea(@PathVariable String area){

        List<CompanyResponse> list = this.categoryService.area(area);
        return new MaApiResponse<>(list);
    }

    /***** 학력 *****/
    @ApiOperation(value = "최종학력", notes = "학력별 회사 리스트를 가져옵니다.")
    @GetMapping("/grade/{grade}")
    public MaApiResponse<List<CompanyResponse>> disGrade(@PathVariable String grade){
        List<CompanyResponse> list = this.categoryService.grade(grade);
        return new MaApiResponse<>(list);
    }

    /***** 경력 *****/
    @ApiOperation(value = "경력명", notes = "경력별 회사 리스트를 가져옵니다.")
    @GetMapping("/experience/{experience}")
    public MaApiResponse<List<CompanyResponse>> disExp(@PathVariable String experience){
        List<CompanyResponse> list = this.categoryService.experience(experience);
        return new MaApiResponse<>(list);
    }

    /***** 복지 *****/
    @ApiOperation(value = "복지명", notes = "해당 복지별 회사 리스트를 가져옵니다.")
    @GetMapping("/welfare/{welfare}")
    public MaApiResponse<List<CompanyResponse>> disWelfare(@PathVariable String welfare){
        List<CompanyResponse> list = this.categoryService.welfare(welfare);
        return new MaApiResponse<>(list);
    }

    /***** 직종 *****/
    @ApiOperation(value = "직종명", notes = "직종별 회사 리스트를 가져옵니다.")
    @GetMapping("/occupation/{occupation}")
    public MaApiResponse<List<CompanyResponse>> disOccupation(@PathVariable String occupation){
        List<CompanyResponse> list = this.categoryService.occupation(occupation);
        return new MaApiResponse<>(list);
    }

    @ApiOperation(value = "작성일", notes = "작성일 순서대로 회사 리스트를 가져옵니다.")
    @GetMapping("/createdDate")
    public MaApiResponse<List<CompanyResponse>> disCreatedDate(){
        List<CompanyResponse> list = this.categoryService.createdDate();
        return new MaApiResponse<>(list);
    }

    @ApiOperation(value = "없음", notes = "세션에 저장된 본인 id로 검색됩니다")
    @GetMapping("/smartMatch")
    public MaApiResponse<List<CompanyResponse>> disSmartMatch() throws ResumeNotFoundException{
        List<CompanyResponse> list = this.categoryService.smartMatch();
        return new MaApiResponse<>(list);
    }

    @ExceptionHandler(ResumeNotFoundException.class)
    public MaApiResponse handleUserNotFound(ResumeNotFoundException exc) {
        return new MaApiResponse(MaApiResponse.NOT_FOUND,"이력서를 먼저 등록해주세요");
    }
}
