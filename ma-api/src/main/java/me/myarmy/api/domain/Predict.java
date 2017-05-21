package me.myarmy.api.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Manki Kim on 2017-05-21.
 */
@Entity
@Table(name = "predict")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Predict extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id",unique = true)
    private long userId;

    @Column(name = "company_id_text")
    private String companyIdText;
}
