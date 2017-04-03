package me.myarmy.api.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Manki Kim on 2017-04-03.
 */

@Component
public class SecuritySuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest requset, HttpServletResponse response
            , Authentication authentication) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_OK);

        List<GrantedAuthority> grantList = (List<GrantedAuthority>)authentication.getAuthorities();

        //TODO URL변경
        int authNum=checkAuthority(grantList);
        switch(authNum){
            case 1:
                response.sendRedirect("http://www.naver.com");
                break;
            case 2:
                response.sendRedirect("http://www.daum.net");
                break;
            case 3:
                response.sendRedirect("/admin_main.html");
        }
    }


    public int checkAuthority(List<? extends GrantedAuthority> grantList){

        String auth = grantList.get(0).getAuthority();

        if(auth.equals("ROLE_BUSINESS"))
            return 1;
        else if(auth.equals("ROLE_USER"))
            return 2;
        else if(auth.equals("ROLE_ADMIN"))
            return 3;
        else
            return 0;

    }
}
