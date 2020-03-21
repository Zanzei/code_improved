package com.fpt.application.model.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fpt.application.model.common.BaseResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "Data Customer")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customers")
public class Customer {
	
	@JsonProperty(value = "cust_id")
	@NotNull
	@ApiModelProperty(notes = "Customer ID", example = "1", required = false, position = 0)
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer custId;

	@JsonProperty(value = "cust_name")
	@NotNull
	@ApiModelProperty(notes = "Customer Full Name", example = "Andre Christian", required = true, position = 1)
	private String custName;
	
	@JsonProperty(value = "cust_address")
	@NotNull
	@ApiModelProperty(notes = "Customer Address", example = "Tangerang Selatan 2", required = false, position = 2)
	private String custAddress;
	
}
