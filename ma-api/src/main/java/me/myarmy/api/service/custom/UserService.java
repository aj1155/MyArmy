package me.myarmy.api.service.custom;

import me.myarmy.api.domain.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by Manki Kim on 2017-04-01.
 */
public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
    public Collection<GrantedAuthority> getAuthorities(String email);
}
