package me.myarmy.api.service.custom;

import me.myarmy.api.domain.User;

/**
 * Created by Manki Kim on 2017-04-01.
 */
public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
