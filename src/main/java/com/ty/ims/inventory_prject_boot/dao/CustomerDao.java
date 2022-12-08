package com.ty.ims.inventory_prject_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ims.inventory_prject_boot.dto.Customer;
import com.ty.ims.inventory_prject_boot.repository.CustomerRepository;

@Repository
public class CustomerDao {
	@Autowired
	CustomerRepository repository;

	public Customer saveOutward(Customer customer) {
		return repository.save(customer);
	}

	public Customer updateOutward(Customer customer) {
		return repository.save(customer);
	}

	public Optional<Customer> updateOutwardById(int id) {
		return repository.findById(id);
	}

	public void deleteOutwardById(Customer customer) {
		repository.delete(customer);
	}
}
