package me.myarmy.api.service.Impl;

import me.myarmy.api.domain.Role;
import me.myarmy.api.domain.User;
import me.myarmy.api.repository.RoleRepository;
import me.myarmy.api.repository.UserRepository;
import me.myarmy.api.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Manki Kim on 2017-04-01.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User findUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public Collection<GrantedAuthority> getAuthorities(String email) {
        List<Role> roles = this.userRepository.findByEmail(email).getRoles();
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole())));
        return authorities;
    }
}
