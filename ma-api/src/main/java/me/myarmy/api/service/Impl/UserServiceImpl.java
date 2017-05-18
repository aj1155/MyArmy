package me.myarmy.api.service.Impl;

import me.myarmy.api.controller.exception.NotUniqueIdException;
import me.myarmy.api.controller.exception.UserNotFoundException;
import me.myarmy.api.controller.model.request.UserRequest;
import me.myarmy.api.domain.Role;
import me.myarmy.api.domain.User;
import me.myarmy.api.repository.RoleRepository;
import me.myarmy.api.repository.UserRepository;
import me.myarmy.api.service.custom.UserService;
import me.myarmy.api.util.ROLEMANAGE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
    public User findUserByEmail(String email) throws UserNotFoundException {
        Optional<User> user = Optional.ofNullable(this.userRepository.findByEmail(email));
        if(user.isPresent()){
            return user.get();
        }else{
            throw new UserNotFoundException("로그인 해주세요");
        }
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void createUser(UserRequest userRequest) throws NotUniqueIdException {
        User user = User.of(userRequest.getEmail(),userRequest.getEncodedPassword().get(),userRequest.getUsername(),userRequest.getEmail());
        user.addRoles(this.roleRepository.findByRole(ROLEMANAGE.ROLE_USER.toString()));
        if(validateBeforeCreate(user)) this.userRepository.save(user);
        else throw new NotUniqueIdException();
    }

    @Override
    public void createBusiness(UserRequest userRequest) throws NotUniqueIdException {
        User user = User.of(userRequest.getEmail(),userRequest.getEncodedPassword().get(),userRequest.getUsername(),userRequest.getEmail());
        user.addRoles(this.roleRepository.findByRole(ROLEMANAGE.ROLE_USER.toString()));
        user.addRoles(this.roleRepository.findByRole(ROLEMANAGE.ROLE_BUSINESS.toString()));
        if(validateBeforeCreate(user)) this.userRepository.save(user);
        else throw new NotUniqueIdException();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities(String email) {
        List<Role> roles = this.userRepository.findByEmail(email).getRoles();
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole())));
        return authorities;
    }

     /* 유효성 검사 */

    private Boolean validateBeforeCreate(User user) {
        User oldUser = this.userRepository.findByEmail(user.getEmail());
        if (oldUser != null)
            return false;
        return true;
    }

    private Boolean validateBeforeUpdate(User user) {
        User oldUser = this.userRepository.findOne(user.getId());
        if (oldUser != null && user.getEmail() != oldUser.getEmail())
            return false;
        return true;
    }
}
