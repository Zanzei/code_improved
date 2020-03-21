package com.fpt.configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Url {
	
	public static final String CUSTOMER_ROOT = "/customer";
	public static final String CUSTOMER_ALL = "/all";
	public static final String CUSTOMER_BY_ID = "/customer/{id}";
	public static final String CUSTOMER_ADD = "/add";
	public static final String CUSTOMER_UPDATE = "/update";
	public static final String CUSTOMER_DELETE = "/delete";
}
