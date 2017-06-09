package com.niit.collabbackend.DAO;

import java.util.List;

import com.niit.collabbackend.model.Job;

public interface JobDAO {

	public boolean addOrUpdateJob(Job job);

	public boolean deleteJob(Job job);

	public List<Job> getListOfJob();

	public Job getParticularJob(int job_id);

}
