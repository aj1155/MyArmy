package me.myarmy.api.domain;

import com.clearspring.analytics.util.Lists;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.mail.SimpleMailMessage;

import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Created by Manki Kim on 2017-04-23.
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MailMessage extends SimpleMailMessage implements Serializable {

    private List<File> attachments;
    private String encoding;
    private boolean htmlContent;

    public MailMessage(){
        super();
        super.setSentDate(Calendar.getInstance().getTime());
        this.attachments = Lists.newArrayList();
    }

    public MailMessage addAttachment(File file) {
        if(file != null) this.attachments.add(file);
        return this;
    }

    public MailMessage removeAttachment(File file){
        if(file != null && this.attachments.contains(file)) this.attachments.remove(file);
        return this;
    }

    public List<File> getAttachments(){
        return Collections.unmodifiableList(this.attachments);
    }

    public boolean isMultipart(){
        return !this.attachments.isEmpty();
    }

}
