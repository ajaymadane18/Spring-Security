package com.jwt.example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.Models.Login;
import com.jwt.example.Models.Register;
import com.jwt.example.Services.HomeService;
@RequestMapping("/Users")
@RestController
public class HomeController {
	@Autowired
     private HomeService homeservice;
	
	@GetMapping("/user")
     public String getUser() {
    	 return "ajay";
     }
	@PostMapping("/register")
	public String saveRegister(@RequestBody Register register) {
		  homeservice.register(register);
		return "Registration successful";
	}
	@PostMapping("/login")
	public String login(@RequestBody Login login) {

	    return homeservice.login(login);
	}
}
