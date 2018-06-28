package com.marsmob.security.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.marsmob.security.dto.User;
import com.marsmob.security.dto.User.UserDetailView;
import com.marsmob.security.dto.User.UserSimpleView;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@JsonView(UserSimpleView.class)
	@GetMapping
	public List<User> query(@RequestParam String username)
	{
		User user = new User();
		List<User> users = Arrays.asList(user, user, user);
		return users;
	}
	
	@JsonView(UserDetailView.class)
	@GetMapping("/{id:\\d+}")
	public User getInfo(@PathVariable String id)
	{
		System.out.println("id:"+ id);
		return new User().setUsername("jevno");
	}
}
