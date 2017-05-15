package me.myarmy.api.service;

import me.myarmy.api.controller.exception.RestNotFoundTitleException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Manki Kim on 2017-05-15.
 */
@Service
public class RestService {

    RestTemplate restTemplate = new RestTemplate();

    private String getApiServerUrl(String domain){
        return "http://" + domain;
    }

    public String getThumb(String originUrl) throws RestNotFoundTitleException {
        try {
            if(!originUrl.contains("http")) originUrl = getApiServerUrl(originUrl);
            ResponseEntity<?> result = restTemplate.getForEntity(originUrl, String.class);
            String txt="<meta property=\"og:image\" content=\"([^\"]+)";
            Pattern pattern = Pattern.compile(txt);
            System.out.println(result.getBody().toString());
            Matcher matcher = pattern.matcher(result.getBody().toString());
            String thumb = null;
            if(matcher.find()){
                thumb = matcher.group(1);
            }
            return thumb;
        } catch (Exception e){
            throw new RestNotFoundTitleException("비정상적인 URL 호출입니다.");
        }

    }
}
