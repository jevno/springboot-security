package com.marsmob.security.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marsmob.security.dto.User;

@RestController
public class UserController {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> query()
	{
		User user = new User();
		List<User> users = Arrays.asList(user, user, user);
		return users;
	}
}
