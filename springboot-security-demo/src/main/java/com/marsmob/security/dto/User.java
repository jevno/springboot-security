package com.marsmob.security.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;

public class User {
	public interface UserSimpleView {};
	public interface UserDetailView extends UserSimpleView {};
	
	private int id;
	private String username;
	
	@NotBlank
	private String password;
	private Date birthday;
	
	@JsonView(UserSimpleView.class)
	public int getId() {
		return id;
	}
	public User setId(int id) {
		this.id = id;
		return this;
	}
	
	@JsonView(UserSimpleView.class)
	public String getUsername() {
		return username;
	}
	public User setUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonView(UserDetailView.class)
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	
	@JsonView(UserSimpleView.class)
	public Date getBirthday() {
		return birthday;
	}
	public User setBirthday(Date birthday) {
		this.birthday = birthday;
		return this;
	}
}
