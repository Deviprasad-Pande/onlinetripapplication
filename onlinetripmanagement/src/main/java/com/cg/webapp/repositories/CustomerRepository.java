package com.cg.webapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.webapp.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public Customer findByEmailAndPassword(String email,String password);

	public List<Package> findAllById(Integer customerId);

	public Optional<Customer> findBy(Customer customer);
}
