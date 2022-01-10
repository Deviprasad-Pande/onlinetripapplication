package com.cg.webapp.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IAdmin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@NotNull(message="Name is Mandatory")
	private String name;
	
	@NotNull(message="UserName is Mandatory")
	private String username;
	
	@Size(min=5,max=8) @NotNull(message="Entering Password is Mandatory")
	private String password;
	
	
	
	
}
