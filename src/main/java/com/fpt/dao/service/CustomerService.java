package com.fpt.dao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fpt.application.model.common.BaseResponse;
import com.fpt.application.model.customer.Customer;
import com.fpt.application.model.customer.response.ResCustAll;

@Service
public interface CustomerService {
	
	public ResCustAll getCustomersAll();
	public ResCustAll getCustomerById(Integer id);
	public BaseResponse insertCustomer(Customer customer);
	public BaseResponse updateCustomer(Customer customer);
	public BaseResponse deleteCustomer(Integer id);
	
}
