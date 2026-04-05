package com.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.model.User;
import com.dashboard.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	// create user
	public User save(User user) {
		return repository.save(user);
	}
	
	// get all users
	public List<User> getAll(){
		return repository.findAll();
	}
	
    // Update status
    public User updateStatus(Long id, boolean active) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setActive(active);
        return repository.save(user);
    }
	
}
