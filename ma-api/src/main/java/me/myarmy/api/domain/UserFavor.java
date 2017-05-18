package me.myarmy.api.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Manki Kim on 2017-05-17.
 */
@Entity
@Table(name = "USER_FAVOR")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFavor extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "COMPANY_ID")
    private int companyId;

    @Column(name = "bokrihs")
    private String bokrihs;

    @Column(name = "cjhakryeok")
    private String cjhakryeok;

    @Column(name = "eopjonggbcdnm")
    private String eopjonggbcdnm;

    @Column(name = "geunmujysido")
    private String geunmujysido;

    public static UserFavor of(int companyId,String userId,String bokrihs,String cjhakryeok,String eopjonggbcdnm,String geunmujysido){
        return UserFavor.builder()
                .companyId(companyId)
                .userId(userId)
                .bokrihs(bokrihs)
                .cjhakryeok(cjhakryeok)
                .eopjonggbcdnm(eopjonggbcdnm)
                .geunmujysido(geunmujysido)
                .build();
    }
}
