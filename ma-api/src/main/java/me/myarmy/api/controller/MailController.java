package me.myarmy.api.controller;

import me.myarmy.api.controller.model.response.MaApiResponse;
import me.myarmy.api.service.MailFactory;
import me.myarmy.api.service.custom.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Manki Kim on 2017-04-30.
 */

@RestController
@RequestMapping("/api/v1/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @Autowired
    private MailFactory mailFactory;

    @PostMapping("/send")
    public MaApiResponse sendMailWithCode(@RequestParam("email") String email){
        String code = this.mailFactory.getCode();
        this.mailService.send(this.mailFactory.generateMail(email,code));
        return new MaApiResponse(code);
    }
}
