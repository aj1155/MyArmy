package me.myarmy.api.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Manki Kim on 2017-04-01.
 */
@Entity
@Table(name = "ROLE")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ROLE")
    private String role;

    public static Role of(String role){
        return Role.builder()
                .role(role)
                .build();
    }

}
