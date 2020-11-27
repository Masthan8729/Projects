package com.example.demo.controller;

import com.example.demo.service.mailService;
import com.example.demo.service.userService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import com.example.demo.vo.User;

@RestController
public class UserController {
	private final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired 
	private userService service;

	 @Autowired
	 private JavaMailSender javaMailSender;

	 @Autowired
	 private mailService mailService;

	  @PostMapping("/registerUser") 
	  @CrossOrigin("http://localhost:4200/register")
	  public void registerUser(@RequestBody User user) throws Exception {
		  String email= user.getEmail();
		  boolean value=service.findUserExists(email);
		  System.out.println(value);
		  if(value==true){
		  	log.info("User successfully registered");
		  	mailService.sendMail(user.getEmail(), "Registration Successful","Dear "+user.getFirstName()+","+"\n\n\n" +
					""+"Thank you for Registering with us. We heartily welcome you to our family");

			  service.saveUser(user);
			  /*SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
			  simpleMailMessage.setFrom("subscriptionManagement247@gmail.com");
			  simpleMailMessage.setTo(user.getEmail());
			  simpleMailMessage.setSubject("Registration Successful");
			  simpleMailMessage.setText("Dear "+user.getFirstName()+", " +
					  "Thank you for Registering with us. We are delighted to welcome you to our family");
			  javaMailSender.send(simpleMailMessage);*/
		  }
		  else {
		  	log.error("Email already exist");
			  throw new Exception("User with email Id " + email + " already exist");
		  }

	  }
	  
	  @PostMapping("/login")
	  @CrossOrigin("http://localhost:4200/login")
	  public User loginUser(@RequestBody User user) throws Exception
	  {

		  String tempEmail=user.getEmail();
		  String tempPass=user.getPassword();
		  User userobj=null;
		  if(tempEmail!=null && tempPass!=null)
		  {
			  userobj=service.fetchUserByEmailAndPassword(tempEmail, tempPass);
		  }
			
			  if(userobj==null) {
			  	log.error("Bad credentials");
			  	throw new Exception("Bad credential"); }
			 
		  return userobj;
	  }

	  @GetMapping("/getUserByEmail/{email}")
	  public User getUserByEmail(@PathVariable String email){
	  	log.info("getting user by email");
	  	User userobj=service.fetchUserByEmail(email);
				return userobj;
	  }

}
