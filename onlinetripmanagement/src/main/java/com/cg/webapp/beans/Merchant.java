package com.cg.webapp.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	
	@NotNull(message="Name is Mandatory")
	private String merchantName;
	
	@NotNull
	private String address;
	
	@Email  @NotNull(message="Email is Mandatory")
	private String email;
	
	@Size(min=5,max=8) @NotNull(message="Entering Password is Mandatory")
	private String password;
	
	@Size(min=10,max=10) @NotNull(message="Mobile Number is Mandatory")
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
