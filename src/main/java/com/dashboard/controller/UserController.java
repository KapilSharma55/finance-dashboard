package com.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.User;
import com.dashboard.service.UserService;

@RestController
@RequestMapping("/admin/users")
public class UserController {

	@Autowired
	private UserService service;
	
	// create user
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public User createUser(@RequestBody User user) {
		return service.save(user);
	}
	
	// get all users
	@GetMapping
	public List<User> getAllUser(){
		return service.getAll();
		
	}
	
	// activate / deactivate
	@PutMapping("/{id}/status")
	public User updateStatus(@PathVariable Long id,@RequestParam boolean active) {
		return service.updateStatus(id, active);
	}
}
