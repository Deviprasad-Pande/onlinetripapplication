package com.cg.webapp.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginBean {
	
	@NotNull(message="UserName is Mandatory")
	private String username;
	
	@Size(min=5,max=8) @NotNull(message="Entering Password is Mandatory")
	private String password;
	private String role;

	

}
