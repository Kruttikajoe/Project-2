package com.niit.collabbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="job")
@Component
public class Job {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int job_id;
		
		private String profile,description,qualification,status;
		
		private Date post_date;

		public int getJob_id() {
			return job_id;
		}

		public void setJob_id(int job_id) {
			this.job_id = job_id;
		}

		public String getProfile() {
			return profile;
		}

		public void setProfile(String profile) {
			this.profile = profile;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getQualification() {
			return qualification;
		}

		public void setQualification(String qualification) {
			this.qualification = qualification;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Date getPost_date() {
			return post_date;
		}

		public void setPost_date(Date post_date) {
			this.post_date = post_date;
		}
		
	}




