package com.fpt.application.model.customer.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fpt.application.model.customer.Customer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Request untuk Customers Operation")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
public class ReqCustOperation {

	private Integer custId;

	@JsonProperty(value = "cust_name")
	@ApiModelProperty(notes = "Customer Full Name", example = "Andre Christian", required = true, position = 1)
	private String custName;
	
	@JsonProperty(value = "cust_address")
	@ApiModelProperty(notes = "Customer Address", example = "Tangerang Selatan 2", required = false, position = 2)
	private String custAddress;
	
}
