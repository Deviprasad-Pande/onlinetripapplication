package com.cg.webapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.webapp.beans.LoginBean;
import com.cg.webapp.beans.Merchant;
import com.cg.webapp.exception.MerchantNotFoundException;
import com.cg.webapp.service.MerchantService;
import com.cg.webapp.service.PackageService;

@RestController
public class MerchentController {

	@Autowired
	private MerchantService mService;
	
	@Autowired
	private PackageService pService;
	
	
	@PostMapping("/registerMerchant")
	public ResponseEntity<Merchant> registerMerchantHandler(@Valid @RequestBody Merchant merchant){
		
	 	Merchant savedMerchant= mService.registerNewMerchant(merchant);
		
	 	
	 	return new ResponseEntity<Merchant>(merchant,HttpStatus.CREATED);
		
	}
	
	
	
	
	
	@PostMapping("/loginMerchant")
	public ResponseEntity<Merchant> loginMerchantHandler(@RequestBody LoginBean loginBean){
		
		if(loginBean.getRole().equals("merchant")) {
			
			Merchant merchant= mService.authenticateMerchant(loginBean.getUsername(), loginBean.getPassword());
		
			
			return new ResponseEntity<Merchant>(merchant,HttpStatus.OK);
			
		}
		else
			throw new MerchantNotFoundException("Invalid Role...");
		
		
		
	}
	
	
	
	
	
}
