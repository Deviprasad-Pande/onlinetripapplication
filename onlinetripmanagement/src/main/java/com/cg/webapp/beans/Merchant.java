package com.cg.webapp.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer merchantId;
	
	private String merchantName;
	private String address;
	private String email;
	private String password;
	private String mobileNo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "merchant")
	private List<Package> packages=new ArrayList<Package>();

	public Integer getMerchantId() {
		// TODO Auto-generated method stub
		return merchantId ;
	}

	public List<Package> getPackages() {
		// TODO Auto-generated method stub
		return getPackages();
	}

	
	
	
}
