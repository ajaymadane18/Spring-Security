package com.jwt.example;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.example.Models.Register;

public interface HomeRepo extends JpaRepository<Register, String> {
	Optional<Register> findByEmail(String email);
}
