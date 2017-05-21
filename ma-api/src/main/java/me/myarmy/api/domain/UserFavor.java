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

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "COMPANY_ID")
    private int companyId;

    @Column(name = "RATING")
    private int rating;

    public static UserFavor of(int companyId,long userId,int rating){
        return UserFavor.builder()
                .companyId(companyId)
                .userId(userId)
                .rating(rating)
                .build();
    }

    public static UserFavor ofUpdate(long id,int companyId,long userId,int rating){
        return UserFavor.builder()
                .id(id)
                .companyId(companyId)
                .userId(userId)
                .rating(rating)
                .build();
    }
}
