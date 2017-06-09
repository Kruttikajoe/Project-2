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
@Table(name="BlogComment")
@Component

public class BlogComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blog_comment_id;
	
	@Column
	private int blog_id;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="blog_id",insertable=false,updatable=false)
	private Blog blog;
	
	@NotEmpty(message="blog comment cannot be empty")
	private String b_comment;
	
	@NotNull(message="comment date cannot be blank")
	private Date comment_date;
	
	@Column
	private int userid;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="userid",insertable=false,updatable=false)
	private Users user;

	public int getBlog_comment_id() {
		return blog_comment_id;
	}

	public void setBlog_comment_id(int blog_comment_id) {
		this.blog_comment_id = blog_comment_id;
	}

	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String getB_comment() {
		return b_comment;
	}

	public void setB_comment(String b_comment) {
		this.b_comment = b_comment;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
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
