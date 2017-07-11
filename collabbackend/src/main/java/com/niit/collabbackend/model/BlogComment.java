package com.niit.collabbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "BlogComment")
@Component

public class BlogComment extends Status {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName = "blog_comment_seq", allocationSize = 1)
	private int bComment_id;

	private String bComment;

	private int user_id;

	private int blog_id;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date bComment_date;

	public int getbComment_id() {
		return bComment_id;
	}

	public void setbComment_id(int bComment_id) {
		this.bComment_id = bComment_id;
	}

	public String getbComment() {
		return bComment;
	}

	public void setbComment(String bComment) {
		this.bComment = bComment;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	public Date getbComment_date() {
		return bComment_date;
	}

	public void setbComment_date(Date bComment_date) {
		this.bComment_date = bComment_date;
	}

}
