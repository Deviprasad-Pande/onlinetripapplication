package com.cg.webapp.service;

import java.util.List;
import com.cg.webapp.beans.IPackage;
import com.cg.webapp.beans.Customer;
import com.cg.webapp.exception.CustomerNotFoundException;
import com.cg.webapp.exception.PackageNotAvailableException;

public interface CustomerService {
	
	public Customer registerNewCustomer(Customer customer);
	
	public Customer authenticateCustomer(String email,String password)throws CustomerNotFoundException ;

	public Customer getCustomerDetailsById(Integer customerId)throws CustomerNotFoundException;
	
	public Customer updateCustomer(Customer customer)throws CustomerNotFoundException;
	
	public List<Customer> getAllRegistedCustomers();
	
	public List<IPackage> getAllPackagesByCustomer(Integer customerId)throws CustomerNotFoundException;
	
	public Customer bookAPackage(IPackage tripPackage)throws PackageNotAvailableException;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
