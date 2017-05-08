package me.myarmy.api.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gain on 2017. 5. 6..
 */
@Entity
@Table(name = "RESUME")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resume extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "UID")
    private String uid;

    @Column(name = "OBJECTIVE")
    private String objective;

    @Column(name = "SPECIALTY")
    private String specialty;

    @Column(name = "LICENSE")
    private String license;

    @Column(name = "GRADE")
    private String grade;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "MISCELLANEOUS")
    private String miscellaneous;

    public static Resume of(String uid, String objective, String specialty, String license, String grade, String address, String miscellaneous){
        return Resume.builder()
                .uid(uid)
                .objective(objective)
                .specialty(specialty)
                .license(license)
                .grade(grade)
                .address(address)
                .miscellaneous(miscellaneous)
                .build();
    }
}
