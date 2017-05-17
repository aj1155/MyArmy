package me.myarmy.api.security.handler;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import me.myarmy.api.controller.exception.UserNotFoundException;
import me.myarmy.api.security.UserDetailsImpl;
import me.myarmy.api.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

/**
 * Created by Manki Kim on 2017-04-05.
 */
@Component
public class JwtTokenHandler {

    private final String secret;
    private final UserService userService;

    @Autowired
    public JwtTokenHandler(@Value("${jwt.secret}") String secret, UserService userService) {
        this.secret = secret;
        this.userService = userService;
    }

    public Optional<UserDetails> parseUserFromToken(String token) throws UserNotFoundException {
        String email = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return Optional.ofNullable(new UserDetailsImpl(userService.findUserByEmail(email),0));
    }

    public String createTokenForUser(UserDetails user) {
        final ZonedDateTime afterOneWeek = ZonedDateTime.now().plusWeeks(1);
        return Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(Date.from(afterOneWeek.toInstant()))
                .compact();
    }
}
