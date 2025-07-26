package com.example.demo.Services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.DTOs.UserRegistrationDto;
import com.example.demo.Models.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);

}
