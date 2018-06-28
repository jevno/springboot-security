package com.marsmob.security.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 不同的包名容易引发java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
 * 在本分支test下添加@SpringBootTest(classes=Base.class)//base.Java位于本分支下 或者将包名改为与其他分支一样的路径。就可以了！
 * @title 		
 * @description	
 * @usage		
 * @copyright	Copyright 2017  marsmob Corporation. All rights reserved.
 * @company		marsmob
 * @author		jevno
 * @create		2018年6月28日下午3:16:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void whenQuerySuccess() throws Exception
	{
		String result = mockMvc.perform(get("/user").param("username", "jevno").contentType(MediaType.APPLICATION_JSON_UTF8))
							.andExpect(status().isOk())
							.andExpect(jsonPath("$.length()").value(3))
							.andReturn().getResponse().getContentAsString();
		
		System.out.println(result);
		
	}
	
	@Test
	public void whenGetInfoSuccess() throws Exception
	{
		String result = mockMvc.perform(get("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8))
							.andExpect(status().isOk())
							.andExpect(jsonPath("$.username").value("jevno"))
							.andReturn().getResponse().getContentAsString();
		
		System.out.println(result);
	}
	
	@Test
	public void whenGetInfoFail() throws Exception
	{
		mockMvc.perform(get("/user/a").contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void whenCreateSuccess() throws Exception
	{
		String content = "{\"username\":\"jevno\",\"password\":null,\"birthday\":"+ new Date().getTime()+"}";
		String result = mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
								.andExpect(status().isOk())
								.andExpect(jsonPath("$.id").value("1"))
								.andReturn().getResponse().getContentAsString();
		
		System.out.println(result);
	}
}
