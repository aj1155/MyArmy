package me.myarmy.api.controller.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Optional;

/**
 * Created by Manki Kik on 2017-04-03.
 */
@ApiModel(value="UserRequest",description = "유저 Request 정보")
@Data
@NoArgsConstructor
public class UserRequest {

    private long id;
    @ApiModelProperty(value = "사용자 이름(필수)")
    @NotNull
    private String username;
    @ApiModelProperty(value = "패스워드 8이상 50이하")
    @Size(min=8, max=50)
    @NotNull
    private String password;
    @ApiModelProperty(value = "이메일(유저 id 동일) 필수")
    //@Pattern(regexp="^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\\\w+\\\\.)+\\\\w+$")
    @NotNull
    private String email;

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
