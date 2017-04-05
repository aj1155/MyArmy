package me.myarmy.api.controller.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.myarmy.api.controller.model.request.UserRequest;
import me.myarmy.api.security.TokenAuthenticationService;
import me.myarmy.api.security.UserAuthentication;
import me.myarmy.api.security.UserDetailsImpl;
import me.myarmy.api.service.custom.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Manki Kim on 2017-04-05.
 */
public class StatelessLoginFilter extends AbstractAuthenticationProcessingFilter {

    private final UserService userService;
    private final TokenAuthenticationService tokenAuthenticationService;

    public StatelessLoginFilter(String urlMapping,TokenAuthenticationService tokenAuthenticationService,UserService userService,
                                AuthenticationManager authenticationManager) {
        super(urlMapping);
        this.userService = userService;
        this.tokenAuthenticationService = tokenAuthenticationService;
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        final UserRequest user = toUser(request);
        String email = user.getEmail();
        final UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()
        ,this.userService.getAuthorities(email));
        return getAuthenticationManager().authenticate(loginToken);
    }

    private UserRequest toUser(HttpServletRequest request) throws IOException {
        return new ObjectMapper().readValue(request.getInputStream(), UserRequest.class);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        System.out.println("result"+authResult.getName());
        final UserDetails authenticatedUser = new UserDetailsImpl(this.userService.findUserByEmail(authResult.getName()),0);
        final UserAuthentication userAuthentication = new UserAuthentication(authenticatedUser);
        tokenAuthenticationService.addJwtTokenToHeader(response, userAuthentication);
        SecurityContextHolder.getContext().setAuthentication(userAuthentication);
    }
}
