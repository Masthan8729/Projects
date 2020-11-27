package com.example.demo.vo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
	@Table(name="registered_user_tbl")
	public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int userId;
	    private String firstName;
	    private String lastName;
		@Column(unique = true,nullable = false)
	    private String email;
	    private String password;



	public User()
	    {

	    }
	    public User( int userId ,String firstName, String lastName, String email, String password) {
	        this.userId=userId;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.password = password;

	    }
		public int getUserId() {
		return userId;
	}

		public void setUserId(int userId) {
		this.userId = userId;
	}

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }





}


