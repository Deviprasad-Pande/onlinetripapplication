package com.cg.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.webapp.beans.Merchant;
import com.cg.webapp.beans.Package;
import com.cg.webapp.exception.MerchantNotFoundException;
import com.cg.webapp.exception.PackageNotFoundException;
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
		 
		 
     @GetMapping("/getpackageDetailsById/{packageId}")
			public ResponseEntity<Package> getPackageDetailsById(@PathVariable Integer packageId) throws PackageNotFoundException {
				Package pack = pService.getPackageDetailsById(packageId);
				return new ResponseEntity<>(pack, HttpStatus.OK);
				}
				
     @GetMapping("/getpackagesCreatedById")
 	public List<Package> getAllPackagesCreatedyMerchant(@PathVariable Integer merchantId) throws MerchantNotFoundException{
 		return pService.getAllPackagesCreatedyMerchant(merchantId);
				
     }
     
     @GetMapping("/getpackagesByEmail/{merchantEmail}")
     public List<Package> getAllPackagesCreatedyMerchantbyEmail(@PathVariable String merchantEmail)throws MerchantNotFoundException{
		return pService.getAllPackagesCreatedyMerchantbyEmail(merchantEmail);
	}
     
     @GetMapping("/getAllPackages")
 	public List<Package> getAllPackages() {
 		return pService.getAllPackages();
	
     }
     
     @PutMapping("/updatepackage") 
 	public ResponseEntity<Package> updatePackage(@RequestBody Package tripPackage) {
 		return new ResponseEntity<>(pService.updatePackage(tripPackage), HttpStatus.OK);
 	}
	
	
	
	
	
	
	
	
	
}
