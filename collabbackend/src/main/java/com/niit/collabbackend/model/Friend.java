package com.niit.collabbackend.model;

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

@Entity
@Table
public class Friend {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int friend_id;

	private String status;

	@Column(name = "userid")
	private int userid;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "userid", insertable = false, updatable = false)
	private Users user;

	public int getFriend_id() {
		return friend_id;
	}

	public void setFriend_id(int friend_id) {
		this.friend_id = friend_id;
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
