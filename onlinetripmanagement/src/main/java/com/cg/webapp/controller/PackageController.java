package com.cg.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.webapp.beans.Merchant;
import com.cg.webapp.beans.Package;
import com.cg.webapp.service.MerchantService;
import com.cg.webapp.service.PackageService;



@RestController
public class PackageController {

	@Autowired
	private PackageService pService;
	
	@Autowired
	private MerchantService mService;
	
	
	@PostMapping("/createPackage/{merchantEmail}")
	public Package createAPackageHandler(@RequestBody Package tripPackage, @PathVariable String merchantEmail) {
		
		Merchant merchant= mService.viewMerchantByUsername(merchantEmail);
		
		tripPackage.setMerchant(merchant);
		tripPackage.setAvailability(tripPackage.getNumberOfPackages());
		
		 return pService.createANewTripPackage(tripPackage);
		 
		 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
