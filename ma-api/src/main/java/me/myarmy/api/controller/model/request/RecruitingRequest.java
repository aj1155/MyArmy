package me.myarmy.api.controller.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by gain on 2017. 5. 4..
 */

@ApiModel(value="RecruitingRequest",description = "recruiting Request 정보")
@Data
@NoArgsConstructor
public class RecruitingRequest {
    private Long Id;

    @ApiModelProperty(value = "userId(email) 필수")
    @NotNull
    private String uid;

    @ApiModelProperty(value = "복리후생 (필수)")
    @NotNull
    private String bokrihs;

    @ApiModelProperty(value = "최종학력 (필수)")
    @NotNull
    private String cjhakryeok;

    @ApiModelProperty(value = "제목 (필수)")
    @NotNull
    private String cyjemokNm;

    @ApiModelProperty(value = "담당자 이름 (필수")
    @NotNull
    private String damdangjaFnm;

    @ApiModelProperty(value = "담당업무 (필수)")
    @NotNull
    private String ddeopmuNm;

    @ApiModelProperty(value = "담당자 연락처")
    private String ddjyeonrakcheoNo;

    @ApiModelProperty(value = "대표연락처 (필수)")
    @NotNull
    private String dpyeonrakcheoNo;

    @ApiModelProperty(value = "업체이름 (필수)")
    @NotNull
    private String eopcheNm;

    @ApiModelProperty(value = "업종구분 (필수)")
    @NotNull
    private String eopjongGbcdNm;

    @ApiModelProperty(value = "근무지 (필수)")
    @NotNull
    private String geunmujy;

    @ApiModelProperty(value = "경력구분 (필수)")
    @NotNull
    private String gyeongryeokGbcdNm;

    @ApiModelProperty(value = "연봉조건 (필수)")
    @NotNull
    private String gyjogeonCdNm;

    @ApiModelProperty(value = "접수방법 (필수)")
    @NotNull
    private String jeopsubb;

    @ApiModelProperty(value = "마감일자 (필수)")
    @NotNull
    private String magamDt;

    @ApiModelProperty(value = "상시채용 여부")
    private String sschaeyongYn;

    @ApiModelProperty(value = "역종구분 (필수)")
    @NotNull
    private String yeokjongBrcdNm;

    @ApiModelProperty(value = "요원구분 (필수)")
    @NotNull
    private String yowonGbcdNm;
}
