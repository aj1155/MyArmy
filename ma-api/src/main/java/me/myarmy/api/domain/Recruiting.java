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
@ToString
@Builder
public class Recruiting extends BaseEntity implements Serializable {


    //공고 번호를 따로 만들어야 할지
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long Id;

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

    private Recruiting(RecruitingBuilder recruitingBuilder){
        this.bokrihs = recruitingBuilder.bokrihs;
        this.cjhakryeok = recruitingBuilder.cjhakryeok;
        this.cyjemokNm = recruitingBuilder.cyjemokNm;
        this.damdangjaFnm = recruitingBuilder.damdangjaFnm;
        this.ddeopmuNm = recruitingBuilder.ddeopmuNm;
        this.ddjyeonrakcheoNo = recruitingBuilder.ddjyeonrakcheoNo;
        this.dpyeonrakcheoNo = recruitingBuilder.dpyeonrakcheoNo;
        this.eopcheNm = recruitingBuilder.eopcheNm;
        this.eopjongGbcdNm = recruitingBuilder.eopjongGbcdNm;
        this.geunmujy = recruitingBuilder.geunmujy;
        this.gyeongryeokGbcdNm = recruitingBuilder.gyeongryeokGbcdNm;
        this.gyjogeonCdNm = recruitingBuilder.gyjogeonCdNm;
        this.jeopsubb = recruitingBuilder.jeopsubb;
        this.magamDt = recruitingBuilder.magamDt;
        this.sschaeyongYn = recruitingBuilder.sschaeyongYn;
        this.yeokjongBrcdNm = recruitingBuilder.yeokjongBrcdNm;
        this.yowonGbcdNm = recruitingBuilder.yowonGbcdNm;

    }

    public static class RecruitingBuilder{
        private String bokrihs;
        private String cjhakryeok;
        private String cyjemokNm;
        private String damdangjaFnm;
        private String ddeopmuNm;
        private String ddjyeonrakcheoNo;
        private String dpyeonrakcheoNo;
        private String eopcheNm;
        private String eopjongGbcdNm;
        private String geunmujy;
        private String gyeongryeokGbcdNm;
        private String gyjogeonCdNm;
        private String jeopsubb;
        private String magamDt;
        private String sschaeyongYn;
        private String yeokjongBrcdNm;
        private String yowonGbcdNm;

        public RecruitingBuilder(){
        }

        public RecruitingBuilder setBokrihs(String bokrihs){
            this.bokrihs = bokrihs;
            return this;
        }

        public RecruitingBuilder setCjhakryeok(String cjhakryeok){
            this.cjhakryeok = cjhakryeok;
            return this;
        }

        public RecruitingBuilder setCyjemokNm(String cyjemokNm){
            this.cyjemokNm = cyjemokNm;
            return this;
        }

        public RecruitingBuilder setDamdangjaFnm(String damdangjaFnm){
            this.damdangjaFnm = damdangjaFnm;
            return this;
        }
        public RecruitingBuilder setDdeopmuNm(String ddeopmuNm){
            this.ddeopmuNm = ddeopmuNm;
            return this;
        }

        public RecruitingBuilder setDdjyeonrakcheoNo(String ddjyeonrakcheoNo){
            this.ddjyeonrakcheoNo = ddjyeonrakcheoNo;
            return this;
        }

        public RecruitingBuilder setDpyeonrakcheoNo(String dpyeonrakcheoNo){
            this.dpyeonrakcheoNo = dpyeonrakcheoNo;
            return this;
        }

        public RecruitingBuilder setEopcheNm(String eopcheNm){
            this.eopcheNm = eopcheNm;
            return this;
        }

        public RecruitingBuilder setEopjongGbcdNm(String eopjongGbcdNm){
            this.eopjongGbcdNm = eopjongGbcdNm;
            return this;
        }

        public RecruitingBuilder setGyeongryeokGbcdNm(String gyeongryeokGbcdNm){
            this.gyeongryeokGbcdNm = gyeongryeokGbcdNm;
            return this;
        }

        public RecruitingBuilder setGeunmujy(String geunmujy){
            this.geunmujy = geunmujy;
            return this;
        }

        public RecruitingBuilder setGyjogeonCdNm(String gyjogeonCdNm){
            this.gyjogeonCdNm = gyjogeonCdNm;
            return this;
        }

        public RecruitingBuilder setJeopsubb(String jeopsubb){
            this.jeopsubb = jeopsubb;
            return this;
        }

        public RecruitingBuilder setMagamDt(String magamDt){
            this.magamDt = magamDt;
            return this;
        }

        public RecruitingBuilder setSschaeyongYn(String sschaeyongYn){
            this.sschaeyongYn = sschaeyongYn;
            return this;
        }

        public RecruitingBuilder setYeokjongBrcdNm(String yeokjongBrcdNm){
            this.yeokjongBrcdNm = yeokjongBrcdNm;
            return this;
        }

        public RecruitingBuilder setYowonGbcdNm(String yowonGbcdNm){
            this.yowonGbcdNm = yowonGbcdNm;
            return this;
        }

        public Recruiting build(){
            return new Recruiting(this);
        }

    }
}
