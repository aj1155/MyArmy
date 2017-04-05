package me.myarmy.api.controller.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

/**
 * Created by Manki Kik on 2017-04-03.
 */
@Data
public class UserRequest {

    private long id;
    private String username;
    private String password;
    private String email;
    private String auth;

    public UserRequest(@JsonProperty("email") String email,
                       @JsonProperty("password") String password,
                       @JsonProperty("name") String username){
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public Optional<String> getEncodedPassword() {
        return Optional.ofNullable(password).map(p -> new BCryptPasswordEncoder().encode(p));
    }

}
