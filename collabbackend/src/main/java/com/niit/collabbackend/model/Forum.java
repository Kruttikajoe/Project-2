package com.niit.collabbackend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Forum")
@Component

public class Forum {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int forum_id;
	
	@NotEmpty(message="forum name cannot be blank")
	private String forum_name;
	
	@NotEmpty(message="forum content cannot be blank")
	private String forum_content;
	
	@NotNull(message="date cannot be blank")
	private Date create_date;
	
	@NotEmpty(message="status cannot be blank")
	private String status;
	
	@Column(name="userid")
	private int userid;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="userid",insertable=false,updatable=false)
	private Users user;

	public int getForum_id() {
		return forum_id;
	}

	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}

	public String getForum_name() {
		return forum_name;
	}

	public void setForum_name(String forum_name) {
		this.forum_name = forum_name;
	}

	public String getForum_content() {
		return forum_content;
	}

	public void setForum_content(String forum_content) {
		this.forum_content = forum_content;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	
	
	
	
	
	
	

	

}
