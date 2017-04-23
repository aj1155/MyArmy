package me.myarmy.api.domain;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/**
 * Created by Manki Kim on 2017-04-23.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ThymeleafMailMessage extends MailMessage implements Serializable {

    private final String templateName;
    private final Map<String,Object> attributes;

    public ThymeleafMailMessage(String templateName){
        this.templateName = templateName;
        this.attributes = Maps.newHashMap();
        super.setHtmlContent(true);
    }

    public ThymeleafMailMessage addAttribute(String key,Object value){
        this.attributes.put(key,value);
        return this;
    }

    public ThymeleafMailMessage removeAttribute(String key){
        if(this.attributes.containsKey(key)) this.attributes.remove(key);
        return this;
    }

    public Map<String,Object> getAttributes(){
        return Collections.unmodifiableMap(this.attributes);
    }
}
