package com.fpt.application.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.application.model.common.BaseResponse;
import com.fpt.application.model.customer.Customer;
import com.fpt.application.model.customer.response.ResCustAll;
import com.fpt.configuration.Url;
import com.fpt.dao.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@Api("Customer CRUD API")
@RequestMapping(Url.CUSTOMER_ROOT)
@RequiredArgsConstructor
@AllArgsConstructor
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@ApiOperation("Mengembalikan list seluruh Customer")
	@RequestMapping(method = RequestMethod.GET, path = Url.CUSTOMER_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResCustAll getCustomers() {
		ResCustAll response = customerService.getCustomersAll();
		return response;
	}

	@ApiOperation("Mengembalikan Customer by ID")
	@RequestMapping(method = RequestMethod.GET, path = Url.CUSTOMER_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResCustAll getCustomerById(@RequestParam Integer id) {
		ResCustAll response = customerService.getCustomerById(id);
		return response;
	}
		
	@ApiOperation("Menambahkan Customer Baru")
	@RequestMapping(method = RequestMethod.POST, path = Url.CUSTOMER_ADD, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse insertCustomer(@RequestBody Customer customer) {
		BaseResponse response = customerService.insertCustomer(customer);
		return response;
	}
	
	@ApiOperation("Mengupdate customer")
	@RequestMapping(method = RequestMethod.PUT, path = Url.CUSTOMER_UPDATE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse updateCustomer(@RequestBody Customer customer) {
		BaseResponse response = customerService.updateCustomer(customer);
		return response;
	}
	
	@ApiOperation("Menghapus customer")
	@RequestMapping(method = RequestMethod.DELETE, path = Url.CUSTOMER_DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse deleteCustomer(@RequestParam Integer id) {
		BaseResponse response = customerService.deleteCustomer(id);
		return response;
	}

}
