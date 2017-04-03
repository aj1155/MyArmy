package me.myarmy.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Manki Kim on 2017-04-03.
 */
@RestController
@RequestMapping("/api/web")
public class WebController {

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/main")
    public String main(){
        return "myarmy";
    }
}
