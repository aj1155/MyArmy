package me.myarmy.api.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Manki Kim on 2017-05-16.
 */
@Entity
@Table(name = "company")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "cygonggono")
    private String cygonggoNo;

    @Column(name = "bokrihs")
    private String bokrihs;

    @Column(name = "ccdatabalsaengdtm")
    private String ccdatabalsaengDtm;

    @Column(name = "cjdatabyeongyeongdtm")
    private String cjdatabyeongyeongDtm;

    @Column(name = "cjhakryeok")
    private String cjhakryeok;

    @Column(name = "damdangjafnm")
    private String damdangjaFnm;

    @Column(name = "ddeopmunm")
    private String ddeopmuNm;

    @Column(name = "ddjyeonrakcheono")
    private String ddjyeonrakcheoNo;

    @Column(name = "dpyeonrakcheono")
    private String dpyeonrakcheoNo;

    @Column(name = "eopchenm")
    private String eopcheNm;

    @Column(name = "eopjonggbcd")
    private String eopjongGbcd;

    @Column(name = "eopjonggbcdnm")
    private String eopjongGbcdNm;

    @Column(name = "geunmujy")
    private String geunmujy;

    @Column(name = "geunmujysido")
    private String geunmujysido;

    @Column(name = "gmjybjusocd")
    private String gmjybjusoCd;

    @Column(name = "grns")
    private String grNs;

    @Column(name = "gyeongryeokgbcdnm")
    private String gyeongryeokGbcdNm;

    @Column(name = "gyjogeoncd")
    private String gyjogeonCd;

    @Column(name = "gyjogeoncdnm")
    private String gyjogeonCdNm;

    @Column(name = "hmpgaddr")
    private String hmpgAddr;

    @Column(name = "jeopsubb")
    private String jeopsubb;

    @Column(name = "jggyeyeolcd")
    private String jggyeyeolCd;

    @Column(name = "jggyeyeolcdnm")
    private String jggyeyeolCdNm;

    @Column(name = "magamdt")
    private String magamDt;

    @Column(name = "oegukeo")
    private String oegukeo;

    @Column(name = "oegukeocd")
    private String oegukeoCd;

    @Column(name = "ogegsneungryeokcdnm")
    private String ogegsneungryeokCdNm;

    @Column(name = "sschaeyongyn")
    private String sschaeyongYn;

    @Column(name = "yeokjongbrcd")
    private String yeokjongBrcd;

    @Column(name = "yeokjongbrcdnm")
    private String yeokjongBrcdNm;

    @Column(name = "yowongbcd")
    private String yowonGbcd;

    @Column(name = "yowongbcdnm")
    private String yowonGbcdNm;

    @Column(name = "yuhyoyn")
    private String yuhyoYn;

}
