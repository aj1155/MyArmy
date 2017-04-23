package me.myarmy.api.service.custom;

import me.myarmy.api.domain.MailMessage;
import org.springframework.mail.MailException;

import java.util.List;

/**
 * Created by Manki Kim on 2017-04-23.
 */
public interface MailService {

    void send(MailMessage message) throws MailException;

    void send(List<MailMessage> messages) throws MailException;
}
