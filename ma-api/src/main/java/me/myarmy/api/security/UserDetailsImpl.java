package me.myarmy.api.security;

import me.myarmy.api.domain.User;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created by Manki Kim on 2017-04-02.
 */
public class UserDetailsImpl implements UserDetails,CredentialsContainer {

    private long id;
    private String username;
    private String password;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public UserDetailsImpl(User user){

        this.id=user.getId();//pk
        this.username=user.getUserName();
        this.password=user.getPassword();
        this.email=user.getEmail();
        this.authorities=getAuthorities(user);
        this.accountNonExpired=true;
        this.accountNonLocked=true;
        this.credentialsNonExpired=true;
        this.enabled=true;

    }

    /*
     * User상태에 따른 생성자
     * 1.계정활성(true:enabled)
     * 2.계정만료(true:none expired)
     * 3.비밀번호만료(true:credential none expired)
     * 4.계정잠금(true:account none locked)
     */
    public UserDetailsImpl(User user,int status){

        this.id=user.getId();//pk
        this.username=user.getUserName();
        this.password=user.getPassword();
        this.email=user.getEmail();
        this.authorities=getAuthorities(user);
        this.accountNonExpired=true;
        this.accountNonLocked=true;
        this.credentialsNonExpired=true;
        this.enabled=true;

        switch(status){
            case 1:
                this.enabled=false;
                break;
            case 2:
                this.accountNonExpired=false;
                break;
            case 3:
                this.credentialsNonExpired=false;
                break;
            case 4:
                this.accountNonLocked=false;
                break;
            default:

        }
    }


    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole())));
        return authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void eraseCredentials() {
    }
}
