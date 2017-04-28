package me.myarmy.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.myarmy.api.controller.exception.NotUniqueIdException;
import me.myarmy.api.controller.model.request.UserRequest;
import me.myarmy.api.controller.model.response.MaApiResponse;
import me.myarmy.api.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Manki Kim on 2017-02-23.
 */
@Api(description = "회원가입 API")
@RestController
@RequestMapping(value = "/api/v1/manage")
public class UserManageController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "유저정보값", notes = "일반 유저 회원 가입입니다.")
    @PostMapping()
    public MaApiResponse create(@Valid @RequestBody UserRequest userRequest){
        this.userService.createUser(userRequest);
        return new MaApiResponse(MaApiResponse.OK);
    }

    @ApiOperation(value = "기업인정보값", notes = "기업인 회원 가입입니다.")
    @PostMapping("/business")
    public MaApiResponse createBusiness(@Valid @RequestBody UserRequest userRequest){
        this.userService.createBusiness(userRequest);
        return new MaApiResponse(MaApiResponse.OK);
    }

    @ExceptionHandler(NotUniqueIdException.class)
    public MaApiResponse handleUserNotFound(NotUniqueIdException exc) {
        return new MaApiResponse(MaApiResponse.DUPLICATE_PATH);
    }

}
