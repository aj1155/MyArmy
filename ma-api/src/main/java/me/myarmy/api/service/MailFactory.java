package me.myarmy.api.service;

import me.myarmy.api.domain.ThymeleafMailMessage;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by Manki Kim on 2017-04-30.
 */
@Service
public class MailFactory {

    public ThymeleafMailMessage generateMail(String email,String code){
        ThymeleafMailMessage mailMessage = new ThymeleafMailMessage("TEST");
        mailMessage.setFrom("win3winkr@gmail.com");
        mailMessage.setTo(email);
        mailMessage.setText("verifyToken : "+code);
        mailMessage.setSubject("[인증]");
        mailMessage.addAttribute("name", "Guest");
        mailMessage.setEncoding("UTF-8");
        return mailMessage;
    }

    public String getCode(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<8;i++){
            sb.append(random.nextInt(9) + 1);
        }
        return sb.toString();
    }
}
