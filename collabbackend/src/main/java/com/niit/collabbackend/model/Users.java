package com.niit.collabbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Users")
@Component

public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	
	@NotEmpty(message = "username cannot be blank")
     private String name;
	
	@NotEmpty(message = "password cannot be blank")
    private String password;
	
	@NotEmpty(message = "email cannot be blank")
	private String email;
	
	@NotEmpty(message = "role cannot be blank")
    private String role;
	
	@NotEmpty(message = "status cannot be blank")
    private String status;
	
	@NotEmpty(message = "isonline cannot be blank")
    private String isOnline;
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	
	
	

	
}
