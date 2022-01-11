package com.cg.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.webapp.beans.Customer;
import com.cg.webapp.beans.IPackage;
import com.cg.webapp.exception.CustomerNotFoundException;
import com.cg.webapp.exception.PackageNotAvailableException;
import com.cg.webapp.repositories.CustomerRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository cRepo;
	
	@Override
	public Customer registerNewCustomer(Customer customer) {
	
	 return cRepo.save(customer);
	}

	@Override
	public Customer authenticateCustomer(String email, String password) throws CustomerNotFoundException {
		Customer customer = cRepo.findByEmailAndPassword(email,password);
		if(customer == null)
		{
			throw new CustomerNotFoundException("Invalid username or password");
		}else
			return customer;
		
	}

	@Override
	public Customer getCustomerDetailsById(Integer customerId) throws CustomerNotFoundException {
		return cRepo.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("No cusotmer with id: " + customerId + " found!!"));
		
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
         cRepo.findBy(customer).orElseThrow(() -> new CustomerNotFoundException("No cusotmer with id: " + customer+ " found!!"));	
		   cRepo.save(customer);
		return customer;
	}

	@Override
	public List<Customer> getAllRegistedCustomers() {
		return cRepo.findAll();
	}

	@Override
	public List<IPackage> getAllPackagesByCustomer(Integer customerId) throws CustomerNotFoundException {
		List<IPackage> packages= cRepo.findAllById(customerId);
		if (packages == null) {
			throw new CustomerNotFoundException("No cusotmer with Name: " + customerId + " found!!");
		}
		return packages;
		
	}

	@Override
	public Customer bookAPackage(IPackage tripPackage) throws PackageNotAvailableException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
