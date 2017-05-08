package me.myarmy.api.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gain on 2017. 5. 4..
 */
@Entity
@Table(name = "RECRUITING")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recruiting extends BaseEntity implements Serializable {


    //공고 번호를 따로 만들어야 할지
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long Id;

    @Column(name = "UID")
    private String uid;

    @Column(name = "WELFARE")
    private String bokrihs;

    @Column(name = "GRADE")
    private String cjhakryeok;

    @Column(name = "TITLE")
    private String cyjemokNm;

    @Column(name = "NAME")
    private String damdangjaFnm;

    //담당업무
    @Column(name = "TASK")
    private String ddeopmuNm;

    //담당자연락처
    @Column(name = "PHONE_NUMBER")
    private String ddjyeonrakcheoNo;

    @Column(name = "COMPANY_PHONE_NUMBER")
    private String dpyeonrakcheoNo;

    @Column(name = "COMPANY_NAME")
    private String eopcheNm;

    @Column(name = "OCCUPATION")
    private String eopjongGbcdNm;

    @Column(name = "ADDRESS")
    private String geunmujy;

    @Column(name = "EXPERIENCE")
    private String gyeongryeokGbcdNm;

    @Column(name = "SALARY_NAME")
    private String gyjogeonCdNm;

    //접수방법
    @Column(name = "APPLY")
    private String jeopsubb;

    @Column(name = "ENDDATE")
    private String magamDt;

    @Column(name = "IMMEDIATE")
    private String sschaeyongYn;

    @Column(name = "SERVE_TYPE")
    private String yeokjongBrcdNm;

    @Column(name = "AGENT_TYPE")
    private String yowonGbcdNm;

    public static Recruiting of(String uid, String bokrihs, String cjhakryeok, String cyjemokNm, String damdangjaFnm, String ddeopmuNm, String ddjyeonrakcheoNo, String dpyeonrakcheoNo, String eopcheNm, String eopjongGbcdNm, String geunmujy, String gyeongryeokGbcdNm, String gyjogeonCdNm, String jeopsubb, String magamDt, String sschaeyongYn, String yeokjongBrcdNm, String yowonGbcdNm){
        return Recruiting.builder()
                .uid(uid)
                .bokrihs(bokrihs)
                .cjhakryeok(cjhakryeok)
                .cyjemokNm(cyjemokNm)
                .damdangjaFnm(damdangjaFnm)
                .ddeopmuNm(ddeopmuNm)
                .ddjyeonrakcheoNo(ddjyeonrakcheoNo)
                .dpyeonrakcheoNo(dpyeonrakcheoNo)
                .eopcheNm(eopcheNm)
                .eopjongGbcdNm(eopjongGbcdNm)
                .geunmujy(geunmujy)
                .gyeongryeokGbcdNm(gyeongryeokGbcdNm)
                .gyjogeonCdNm(gyjogeonCdNm)
                .jeopsubb(jeopsubb)
                .magamDt(magamDt)
                .yeokjongBrcdNm(yeokjongBrcdNm)
                .sschaeyongYn(sschaeyongYn)
                .yowonGbcdNm(yowonGbcdNm)
                .build();
    }
}
