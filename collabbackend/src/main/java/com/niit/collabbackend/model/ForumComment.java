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
@Table(name="ForumComment")
@Component

public class ForumComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int forum_comment_id;
	
	@Column
	private int forum_id;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="forum_id",insertable=false,updatable=false)
	private Forum forum;

	@NotEmpty(message="forum comment cannot be empty")
	private String f_comment;
	
	@NotNull(message="comment date cannot be blank")
	private Date create_date;
	
	@Column
	private int userid;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="userid",insertable=false,updatable=false)
	private Users user;

	public int getForum_comment_id() {
		return forum_comment_id;
	}

	public void setForum_comment_id(int forum_comment_id) {
		this.forum_comment_id = forum_comment_id;
	}

	public int getForum_id() {
		return forum_id;
	}

	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public String getF_comment() {
		return f_comment;
	}

	public void setF_comment(String f_comment) {
		this.f_comment = f_comment;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
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
