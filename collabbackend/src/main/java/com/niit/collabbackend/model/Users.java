package com.niit.collabbackend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonManagedReference
	private List<Blog> blog = new ArrayList<Blog>();
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonManagedReference
	private List<Forum> forum = new ArrayList<Forum>();
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonManagedReference
	private List<Friend> friend =  new ArrayList<Friend>();
	
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

	public List<Blog> getBlog() {
		return blog;
	}

	public void setBlog(List<Blog> blog) {
		this.blog = blog;
	}

	public List<Forum> getForum() {
		return forum;
	}

	public void setForum(List<Forum> forum) {
		this.forum = forum;
	}

	public List<Friend> getFriend() {
		return friend;
	}

	public void setFriend(List<Friend> friend) {
		this.friend = friend;
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
