package me.myarmy.api.domain;

import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manki Kim on 2017-04-01.
 */
@Entity
@Table(name = "USER")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LOGIN_ID")
    private String loginId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "EMAIL")
    @Email(message = "*Please provide a valid Email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public void addRoles(Role role){
        if(roles==null){
            roles = new ArrayList<>();
        }
        this.roles.add(role);
    }

    public static User of(String loginId,String password,String userName,String email){
        return User.builder()
                .loginId(loginId)
                .password(password)
                .userName(userName)
                .email(email)
                .build();
    }
}
