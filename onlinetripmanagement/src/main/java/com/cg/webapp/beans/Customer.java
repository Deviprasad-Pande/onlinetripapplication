package com.cg.webapp.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotNull(message="Name is Mandatory")
	private String customerName;
	
	@Email  @NotNull(message="Email is Mandatory")
	private String email;
	
	@Size(min=5,max=8) @NotNull(message="Entering Password is Mandatory")
	private String password;
	
	@NotNull
	private String adddress;
	
	@Size(min=10,max=10) @NotNull(message="Mobile Number is Mandatory")
	private String mobileNo;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private List<Package> packages= new ArrayList<Package>();
	
	
	
	
	
	
	
	
	
	
}
