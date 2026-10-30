package com.jwt.example.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jwt.example.HomeRepo;
import com.jwt.example.Models.CustomUserDetails;
import com.jwt.example.Models.Register;
import com.jwt.example.Services.CustomUserDetailsService;

public class CustomUserDetailsDao implements CustomUserDetailsService{

	
	 @Autowired
		private HomeRepo homerepo;
	  public UserDetails loadUserByUsername(String email)
	            throws UsernameNotFoundException {

	        Register register = homerepo.findByEmail(email)
	                .orElseThrow(() ->
	                    new UsernameNotFoundException("User not found"));

	        return new CustomUserDetails(register);
	    }

}
