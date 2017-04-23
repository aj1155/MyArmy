package me.myarmy.api.service.Impl;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.domain.MailMessage;
import me.myarmy.api.domain.ThymeleafMailMessage;
import me.myarmy.api.service.custom.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Locale;

/**
 * Created by Manki Kim on 2017-04-23.
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;
    private static TemplateEngine templateEngine;

    @Override
    public void send(MailMessage message) throws MailException {
        sendMail(message);
    }

    @Override
    public void send(List<MailMessage> messages) throws MailException {
        messages.forEach(message -> sendMail(message));
    }


    private void sendMail(MailMessage message) {
        try {
            log.debug(">> Send mailMessage: {}", message);
            doSend(message);
            /* TODO ITemplareEngine Not Found Error 해결
            if (ThymeleafMailMessage.class.isAssignableFrom(message.getClass())) {
                doThymeleafMailMessageSend((ThymeleafMailMessage) message);
            } else {
                doSend(message);
            }
            */
        } catch (Exception e) {
            log.error(">> Occur Exception: {}", e.getMessage());
        }
    }

    private void doThymeleafMailMessageSend(ThymeleafMailMessage thymeleafMailMessage) throws MessagingException {
        Context context = new Context(Locale.getDefault());
        context.setVariables(thymeleafMailMessage.getAttributes());
        thymeleafMailMessage.setText(templateEngine.process(thymeleafMailMessage.getTemplateName(), context));

        doSend(thymeleafMailMessage);
    }

    private void doSend(MailMessage message) throws MessagingException {
        try {
            MimeMessage mimeMessage = new MimeMessage(Session.getInstance(System.getProperties()));
            MimeMessageHelper helper = getMimeMessageHelper(message, mimeMessage);
            mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            throw e;
        }
    }

    private MimeMessageHelper getMimeMessageHelper(MailMessage message,MimeMessage mimeMessage) throws MessagingException {
        MimeMessageHelper mimeMessageHelper = makeMessageHelper(message,mimeMessage);
        mimeMessageHelper.setFrom(message.getFrom());
        mimeMessageHelper.setTo(message.getTo());
        if (null != message.getCc()) {
            mimeMessageHelper.setCc(message.getCc());
        }
        if (null != message.getBcc()) {
            mimeMessageHelper.setBcc(message.getBcc());
        }

        mimeMessageHelper.setSubject(message.getSubject());
        mimeMessageHelper.setText(message.getText(), message.isHtmlContent());
        mimeMessageHelper.setSentDate(message.getSentDate());
        return mimeMessageHelper;
    }

    private MimeMessageHelper makeMessageHelper(MailMessage message, MimeMessage mimeMessage) throws MessagingException {
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, message.isMultipart());
        if (StringUtils.hasText(message.getEncoding())) {
            helper = new MimeMessageHelper(mimeMessage, message.isMultipart(), message.getEncoding());
        }
        return helper;
    }
}
