package com.jwt.example.Services;

import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserDetailsService {
	 public UserDetails loadUserByUsername(String email);
}
