package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method = RequestMethod.POST, path = "/create")
	public @ResponseBody User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/createWithPosts")
	public @ResponseBody User addUserWithPosts(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/read")
	public @ResponseBody Iterable<User> getAllUsers() {
		System.out.println("oi");
		return userRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/update")
	public @ResponseBody User updateUser(@RequestBody User user) {
		Optional<User> optionalUser = userRepository.findById(user.getId());
		User targetUser = optionalUser.get();
		targetUser.setName(user.getName());
		targetUser.setEmail(user.getEmail());
		return userRepository.save(targetUser);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/delete")
	public @ResponseBody Integer deleteUser(@RequestBody Integer id) {
		userRepository.deleteById(id);
		return id;
	}

}
