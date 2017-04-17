package me.myarmy.api.controller.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Optional;

/**
 * Created by Manki Kik on 2017-04-03.
 */
@Data
@NoArgsConstructor
public class UserRequest {

    private long id;
    @NotNull
    private String username;
    @Size(min=8, max=50)
    private String password;
    @Pattern(regexp="^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\\\w+\\\\.)+\\\\w+$")
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
