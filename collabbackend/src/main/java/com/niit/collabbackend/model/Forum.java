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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Forum")
@Component

public class Forum extends Status {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName = "forum_seq", allocationSize = 1)
	private int forum_id;

	private String forum_name, forum_content, status;

	private int user_id;

	@Temporal(TemporalType.DATE)
	private Date create_date;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

}
