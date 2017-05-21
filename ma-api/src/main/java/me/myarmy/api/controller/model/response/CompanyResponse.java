package me.myarmy.api.controller.model.response;

import lombok.*;
import me.myarmy.api.domain.Company;

/**
 * Created by Manki Kim on 2017-03-04.
 * email : aj1155@naver.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyResponse {

    private int id;
    private String ccdatabalsaengdtm;
    private String cjdatabyeongyeongdtm;
    private String cjhakryeok;
    private String ddeopmuNm;
    private String eopcheNm;
    private String magamDt;
    private String geunmujysido;
    private String gyeongryeokGbcdNm;
    private String gyjogeonCdNm;

    public static CompanyResponse of(Company company){
        return CompanyResponse.builder()
                .cjhakryeok(company.getCjhakryeok())
                .id(company.getId())
                .ccdatabalsaengdtm(company.getCcdatabalsaengDtm())
                .cjdatabyeongyeongdtm(company.getCjdatabyeongyeongDtm())
                .ddeopmuNm(company.getDdeopmuNm())
                .eopcheNm(company.getEopcheNm())
                .magamDt(company.getMagamDt())
                .geunmujysido(company.getGeunmujysido())
                .gyeongryeokGbcdNm(company.getGyeongryeokGbcdNm())
                .gyjogeonCdNm(company.getGyjogeonCdNm())
                .build();
    }
}
