package com.cdacproject.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdacproject.dao.XRepository;
import com.cdacproject.model.Fd;
import com.cdacproject.model.User;
import com.cdacproject.model.UserStatus;
import com.cdacproject.service.ServiceLayer;

@CrossOrigin(origins = "*")
@RestController
public class Controller {
    
	private XRepository r;
	
	@Autowired 
	private ServiceLayer service;
	
	/*
	@Autowired
	public void f1(XRepository y)
	{ 
		System.out.println("autowired successfully......");
		r =y;
		
	}
	*/
	
	@GetMapping(value="/")
	public String defaultMethod() {
		System.out.println("Thsi is defaukt method");
		return "Hello Apna bank ";
	}
	
	
	@GetMapping("/hw")
	public String check()
	{
		System.out.println("inside check metthod");
		return "hey web servcie is working";
		
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {

		return service.register(user);

	}
	
	@GetMapping("/login")
	public User userLogin(@RequestParam String userId, @RequestParam String password)
	{
		System.out.println("inside login controller "+userId+" "+password);
		return service.userLogin(userId, password);
	}
	
	@PostMapping("/fd")
	public Fd fdBooking(@RequestBody Fd fixedDeposite) throws ParseException
	{
		//User Id, Period, Amount,interestRate
		
		return service.fdBooking(fixedDeposite);
	}
	
	@GetMapping("/fdstatement")
	public List<Fd> fdStatement(@RequestParam("userId") String userId)
	{
		return service.fdStatement(userId);
	}
	
	@GetMapping("/userById")
	public User getUserById(@RequestParam String userId)
	{
		return service.getUserByUserId(userId);
	}
}
