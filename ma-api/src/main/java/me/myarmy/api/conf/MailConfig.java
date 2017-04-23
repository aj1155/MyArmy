package me.myarmy.api.conf;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import javax.validation.constraints.NotNull;
import java.util.Properties;

/**
 * Created by Manki Kim on 2017-04-23.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "mail")
public class MailConfig {

    private static final String MAIL_DEBUG = "mail.debug";
    private static final String MAIL_SMTP_STARTTLS_REQUIRED = "mail.smtp.starttls.required";
    private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    private static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";

    @NotBlank
    private String host;
    private String protocol;
    private int port;
    private String username;
    private String password;
    private String defaultEncoding;
    @NotNull
    private Smtp smtp;

    @Data
    public static class Smtp {
        private boolean auth;
        private boolean startTlsRequired;
        private boolean startTlsEnable;
    }

    @Bean
    public JavaMailSender mailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(getHost());
        mailSender.setProtocol(getProtocol());
        mailSender.setPort(getPort());
        mailSender.setUsername(getUsername());
        mailSender.setPassword(getPassword());
        mailSender.setDefaultEncoding(getDefaultEncoding());
        Properties properties = mailSender.getJavaMailProperties();
        properties.put(MAIL_SMTP_STARTTLS_REQUIRED, getSmtp().isStartTlsRequired());
        properties.put(MAIL_SMTP_STARTTLS_ENABLE, getSmtp().isStartTlsEnable());
        properties.put(MAIL_SMTP_AUTH, getSmtp().isAuth());
        properties.put(MAIL_DEBUG, true);
        mailSender.setJavaMailProperties(properties);
        return mailSender;

    }

    @Bean
    public TemplateResolver emailTemplateResolver() {
        TemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
        emailTemplateResolver.setPrefix("mails/");
        emailTemplateResolver.setSuffix(".html");
        emailTemplateResolver.setTemplateMode("HTML5");
        emailTemplateResolver.setCharacterEncoding("UTF-8");
        emailTemplateResolver.setCacheable(true);
        return emailTemplateResolver;
    }
    /*
    @Bean
    public TemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(emailTemplateResolver());
        return engine;
    }
    */
}
