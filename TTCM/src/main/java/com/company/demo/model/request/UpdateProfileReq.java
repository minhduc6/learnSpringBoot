package com.company.demo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfileReq {
    private String phone;

    @NotNull(message = "Họ tên trống")
    @NotEmpty(message = "Họ tên trống")
    @ApiModelProperty(
            example="Sam Smith",
            notes="Họ tên trống",
            required=true
    )
    @JsonProperty("full_name")
    private String fullName;

    @ApiModelProperty(
            example="Ha Noi",
            required=false
    )
    private String address;
}
