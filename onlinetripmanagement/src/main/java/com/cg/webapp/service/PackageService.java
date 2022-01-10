package com.cg.webapp.service;

import java.util.List;

import com.cg.webapp.beans.Package;
import com.cg.webapp.exception.MerchantNotFoundException;
import com.cg.webapp.exception.PackageNotFoundException;

public interface PackageService {
	
	public Package createANewTripPackage(Package tripPackage);
	
	public Package getPackageDetailsById(Integer packageId)throws PackageNotFoundException;
	
	public List<Package> getAllPackagesCreatedyMerchant(Integer merchantId)throws MerchantNotFoundException;

	public List<Package> getAllPackagesCreatedyMerchantbyEmail(String merchantEmail)throws MerchantNotFoundException;
	public List<Package> getAllPackages();
	
	public Package updatePackage(Package tripPackage);
	
	
	
	
	
	
	
}
