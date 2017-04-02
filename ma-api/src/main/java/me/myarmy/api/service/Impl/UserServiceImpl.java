package me.myarmy.api.service.Impl;

import me.myarmy.api.domain.User;
import me.myarmy.api.repository.RoleRepository;
import me.myarmy.api.repository.UserRepository;
import me.myarmy.api.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public void saveUser(User user) {

    }
}
