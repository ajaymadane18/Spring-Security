package com.jwt.example.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.example.HomeRepo;
import com.jwt.example.Models.Login;
import com.jwt.example.Models.Register;
import com.jwt.example.Services.HomeService;

@Service
public class HomeDao implements HomeService{
      @Autowired
	private HomeRepo homerepo; 
      @Autowired
      private PasswordEncoder passwordEncoder;
      
	@Override
	public void register(Register register) {

	    String encodedPassword =
	            passwordEncoder.encode(register.getPassword());

	    register.setPassword(encodedPassword);

	    homerepo.save(register);
	}
	
	public String login(Login login) {

	    Optional<Register> user =
	            homerepo.findByEmail(login.getEmail());

	    if (user.isPresent()) {

	        if (user.get().getPassword().equals(login.getPassword())) {
	            return "Login successful";
	        }
	    }

	    return "Invalid email or password";
	}
      
}
