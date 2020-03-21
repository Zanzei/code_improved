package com.fpt.application.model.customer.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fpt.application.model.common.BaseResponse;
import com.fpt.application.model.customer.Customer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Response untuk Get Customers")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
public class ResCustAll extends BaseResponse {

	@ApiModelProperty(notes = "Customers", required = false, position = 0)
	private List<Customer> customers;
	
	public ResCustAll() {
		this.customers = new ArrayList<>();
	}
}
