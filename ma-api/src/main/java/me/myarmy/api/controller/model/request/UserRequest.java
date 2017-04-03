package me.myarmy.api.controller.model.request;

import lombok.Data;

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
}
