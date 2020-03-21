package com.fpt.application.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {

	@ApiModelProperty(notes = "Response Code", example = "00", required = true, position = 99)
	private String responseCode;
	
	@ApiModelProperty(notes = "Response Message", example = "SUCCESS", required = true, position = 99)
	private String responseMessage;
	
}
