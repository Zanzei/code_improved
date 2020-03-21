package com.fpt.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fpt.application.model.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<Customer> findAll();
	List<Customer> findByCustId(Integer custId);

}
