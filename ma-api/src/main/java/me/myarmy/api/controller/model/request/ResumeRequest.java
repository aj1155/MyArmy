package me.myarmy.api.controller.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by gain on 2017. 5. 6..
 */
@ApiModel(value="ResumeRequest",description = "resyme Request 정보")
@Data
@NoArgsConstructor
public class ResumeRequest {
    private Long id;

    @ApiModelProperty(value = "userId(email) 필수")
    @NotNull
    private String uid;

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

    private String miscellaneous;

}
