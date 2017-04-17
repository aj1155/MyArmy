package me.myarmy.api.controller;

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
@RestController
@RequestMapping(value = "/api/v1/manage")
public class UserManageController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public MaApiResponse create(@Valid @RequestBody UserRequest userRequest){
        this.userService.createUser(userRequest);
        return new MaApiResponse(MaApiResponse.OK);
    }

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
