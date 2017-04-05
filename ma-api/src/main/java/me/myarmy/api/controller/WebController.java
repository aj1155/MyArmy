package me.myarmy.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Manki Kim on 2017-04-03.
 */
@RestController
@RequestMapping("/api/users")
public class WebController {

    @GetMapping("/main")
    public String show(){
        return "army";
    }

    @GetMapping("/login")
    public String main(){
        return "myarmy";
    }
}
