package com.cg.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.webapp.beans.Customer;
import com.cg.webapp.exception.CustomerNotFoundException;
import com.cg.webapp.exception.PackageNotAvailableException;
import com.cg.webapp.exception.PackageNotFoundException;
import com.cg.webapp.repositories.CustomerRepository;
import com.cg.webapp.repositories.MerchantRepository;
import com.cg.webapp.repositories.PackageRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository cRepo;
	
	@Autowired
	private PackageRepository pRepo;
	

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
            cRepo.findById(customer.getCustomerId()).orElseThrow(() -> new CustomerNotFoundException("No cusotmer with id: " + customer.getCustomerId() + " found!!"));
            return cRepo.save(customer);
	}

	@Override
	public List<Customer> getAllRegistedCustomers() {
		
		
		return cRepo.findAll();
	}

	@Override
	public List<Package> getAllPackagesByCustomer(Integer customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		pRepo.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("No cusotmer with id: " + customerId() + " found!!"));
       return Package;
	}

	@Override
	public Customer bookAPackage(Package tripPackage) throws PackageNotAvailableException {
		// TODO Auto-generated method stub
		return null;
	}

}
