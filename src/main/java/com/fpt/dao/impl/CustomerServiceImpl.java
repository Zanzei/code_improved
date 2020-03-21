package com.fpt.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fpt.application.model.common.BaseResponse;
import com.fpt.application.model.customer.Customer;
import com.fpt.application.model.customer.response.ResCustAll;
import com.fpt.configuration.ErrorCode;
import com.fpt.dao.repository.CustomerRepository;
import com.fpt.dao.service.CustomerService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Component
public class CustomerServiceImpl implements CustomerService{

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public ResCustAll getCustomersAll() {
		ResCustAll response = new ResCustAll();
		ErrorCode errorCode = ErrorCode.GENERAL_EXCEPTION;
		try {
			List<Customer> customers = customerRepository.findAll();
			response.setCustomers(customers);
			errorCode = checkNotFound(customers);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		response.setResponseCode(errorCode.getCode());
		response.setResponseMessage(errorCode.getMessage());
		return response;
	}
	
	@Override
	public ResCustAll getCustomerById(Integer id) {
		ResCustAll response = new ResCustAll();
		ErrorCode errorCode = ErrorCode.GENERAL_EXCEPTION;	
		try {
			List<Customer> customers = customerRepository.findByCustId(id);
			response.setCustomers(customers);
			errorCode = checkNotFound(customers);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		response.setResponseCode(errorCode.getCode());
		response.setResponseMessage(errorCode.getMessage());
		return response;
	}

	@Transactional
	@Override
	public BaseResponse insertCustomer(Customer customer) {
		BaseResponse response = new BaseResponse();
		ErrorCode errorCode = ErrorCode.GENERAL_EXCEPTION;	
		try {
			customer.setCustId(null);
			Customer customerOp = customerRepository.save(customer);
			errorCode = checkFailedOperation(customerOp);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		response.setResponseCode(errorCode.getCode());
		response.setResponseMessage(errorCode.getMessage());
		return response;
	}

	@Override
	public BaseResponse updateCustomer(Customer customer) {
		BaseResponse response = new BaseResponse();
		ErrorCode errorCode = ErrorCode.GENERAL_EXCEPTION;
		try {
			Customer customerFromDb = customerRepository.findById(customer.getCustId()).orElse(null);
			if(customerFromDb != null) {
				customerFromDb.setCustName(customer.getCustName() != null ? customer.getCustName() : customerFromDb.getCustName());
				customerFromDb.setCustAddress(customer.getCustAddress() != null ? customer.getCustAddress() : customerFromDb.getCustAddress());
				customerFromDb = customerRepository.save(customerFromDb);
			}
			errorCode = checkFailedOperation(customerFromDb);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		response.setResponseCode(errorCode.getCode());
		response.setResponseMessage(errorCode.getMessage());
		return response;
	}

	@Override
	public BaseResponse deleteCustomer(Integer id) {
		BaseResponse response = new BaseResponse();
		ErrorCode errorCode = ErrorCode.GENERAL_EXCEPTION;	
		try {
			 customerRepository.deleteById(id);
			 errorCode = ErrorCode.SUCCESS;
		} catch (EmptyResultDataAccessException empty) {
			errorCode = ErrorCode.FAILED_OPERATION;
		} catch(Exception e) {
			e.printStackTrace();
			errorCode = ErrorCode.GENERAL_EXCEPTION;
		}
		
		response.setResponseCode(errorCode.getCode());
		response.setResponseMessage(errorCode.getMessage());
		return response;
	}

	// Error-Checking
	private <T> ErrorCode checkNotFound(List<T> list) {
		try {
			if(list == null || list.isEmpty()) {
				return ErrorCode.NOT_FOUND;
			}
		} catch (Exception e) {
			return ErrorCode.GENERAL_EXCEPTION;
		}
		
		return ErrorCode.SUCCESS;	
	}
	
	private <T> ErrorCode checkFailedOperation(T object) {
		try {
			if(object == null) {
				return ErrorCode.FAILED_OPERATION;
			}
		} catch (Exception e) {
			return ErrorCode.GENERAL_EXCEPTION;
		}
		
		return ErrorCode.SUCCESS;	
	}
}
