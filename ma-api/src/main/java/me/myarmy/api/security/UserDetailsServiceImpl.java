package me.myarmy.api.security;

import me.myarmy.api.domain.User;
import me.myarmy.api.repository.UserRepository;
import me.myarmy.api.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Manki Kim on 2017-04-03.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, UserService userService){
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user;
        try{
            user = this.userService.findUserByEmail(email);
        }catch(Exception e){
            throw new UsernameNotFoundException("접속자 정보를 찾을 수 없습니다. 회원 정보를 정확히 기입 해주세요.");
        }
        UserDetailsImpl userDetails = new UserDetailsImpl(user,0);
        return userDetails;
    }

}
