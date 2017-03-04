package me.myarmy.api.controller;

import me.myarmy.api.controller.model.response.MaApiResponse;
import me.myarmy.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/area/{area}")
    public MaApiResponse<List<Object>> disArea(@PathVariable String area){
        List<Object> list = this.categoryService.area(area);
        return new MaApiResponse<>(list);
    }
}
