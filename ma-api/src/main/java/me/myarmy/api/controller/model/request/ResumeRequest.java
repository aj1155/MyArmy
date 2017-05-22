package me.myarmy.api.controller.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by gain on 2017. 5. 6..
 */
@ApiModel(value="ResumeRequest",description = "resume Request 정보")
@Data
@NoArgsConstructor
public class ResumeRequest {
    private Long id;

    @ApiModelProperty(value = "해당 유저 id")
    private long uid;

    @ApiModelProperty(value = "희망직종(필수)")
    @NotNull
    private String objective;

    private String specialty;

    private String license;

    @ApiModelProperty(value = "최종학력 (필수)")
    @NotNull
    private String grade;

    @ApiModelProperty(value = "거주지 (필수)")
    @NotNull
    private String address;

    //기타경력사항
    private String miscellaneous;

}
