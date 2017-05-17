package me.myarmy.api.security;

import me.myarmy.api.controller.exception.UserNotFoundException;
import me.myarmy.api.security.handler.JwtTokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Manki Kim on 2017-04-05.
 */

@Service
public class TokenAuthenticationService {

    private static final String AUTH_HEADER_NAME = "x-auth-token";

    private final JwtTokenHandler jwtTokenHandler;

    @Autowired
    public TokenAuthenticationService(JwtTokenHandler jwtTokenHandler) {
        this.jwtTokenHandler = jwtTokenHandler;
    }

    public void addJwtTokenToHeader(HttpServletResponse response,
                                    UserAuthentication authentication){
        final UserDetails user = authentication.getDetails();
        response.addHeader(AUTH_HEADER_NAME,this.jwtTokenHandler.createTokenForUser(user));
    }

    public Authentication generateAuthenticationFromRequest(HttpServletRequest request) throws UserNotFoundException{
        final String token = request.getHeader(AUTH_HEADER_NAME);
        if(token == null || token.isEmpty()) return null;
        return this.jwtTokenHandler
                .parseUserFromToken(token)
                .map(UserAuthentication::new)
                .orElse(null);
    }

}
