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
@Table(name="Blog")
@Component

public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int blog_id;
	
	@NotEmpty(message="blog name cannot be blank")
	private String blog_name;
	
	@NotEmpty(message="blog content cannot be blank")
	private String blog_content;
	
    @Column(name="userid")
    private int userid;
    
    @ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="userid",insertable=false,updatable=false)
	private Users user;
    
    @NotEmpty(message="Date cannot be blank")
	private Date create_date;
    
    @NotNull(message="status cannot be blank")
	private String status;
    
    @NotNull(message="likes cannot be blank")
	private int likes;
    
    
    public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	public String getBlog_name() {
		return blog_name;
	}

	public void setBlog_name(String blog_name) {
		this.blog_name = blog_name;
	}

	public String getBlog_content() {
		return blog_content;
	}

	public void setBlog_content(String blog_content) {
		this.blog_content = blog_content;
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

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	
    
    
    
	


	

}
