package me.myarmy.service;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.domain.ThymeleafMailMessage;
import me.myarmy.api.service.custom.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Manki Kim on 2017-04-23.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void sendTest(){
        ThymeleafMailMessage mailMessage = new ThymeleafMailMessage("TEST");
        mailMessage.setFrom("win3winkr@gmail.com");
        mailMessage.setTo("dlrkdls91@naver.com");
        mailMessage.setText("verifyToken : 123456");
        mailMessage.setSubject("[Test] mailTest");
        mailMessage.addAttribute("name", "Guest");
        mailMessage.addAttribute("verify", "123445");
        mailMessage.setEncoding("UTF-8");
        mailService.send(mailMessage);
    }
}
