package me.myarmy.api.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Manki Kim on 2017-04-03.
 */
@Component
public class SecurityFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest requset, HttpServletResponse response, AuthenticationException authentication)
            throws IOException, ServletException {
        //TODO URL변경
        response.sendRedirect("http://www.skhu.ac.kr");
    }
}
