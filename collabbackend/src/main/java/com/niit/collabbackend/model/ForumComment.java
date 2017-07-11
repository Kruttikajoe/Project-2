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
@Table(name = "ForumComment")
@Component

public class ForumComment extends Status {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName = "forum_comment_seq", allocationSize = 1)
	private int fComment_id;

	private String fComment;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fComment_date;

	public int getfComment_id() {
		return fComment_id;
	}

	public void setfComment_id(int fComment_id) {
		this.fComment_id = fComment_id;
	}

	public String getfComment() {
		return fComment;
	}

	public void setfComment(String fComment) {
		this.fComment = fComment;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getForum_id() {
		return forum_id;
	}

	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}

	public Date getfComment_date() {
		return fComment_date;
	}

	public void setfComment_date(Date fComment_date) {
		this.fComment_date = fComment_date;
	}

	private int user_id;

	private int forum_id;

}
