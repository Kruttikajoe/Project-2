package com.niit.collabbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collabbackend.DAO.JobDAO;
import com.niit.collabbackend.model.Job;

@RestController

public class JobController {
	
	@Autowired
	JobDAO jobDAO;
	
	// Get the list of all Jobs
	@RequestMapping(value="/getJobs", method=RequestMethod.GET)
	public ResponseEntity<List<Job>> getJobs()
	{
		List<Job> jobslist = jobDAO.getListOfJob();
		return new ResponseEntity<List<Job>>(jobslist,HttpStatus.OK);
	}
	
	// Add a particular Job details
	@RequestMapping(value="/addJob", method=RequestMethod.POST)
	public ResponseEntity<String> addJob(@RequestBody Job job)
	{
		jobDAO.addOrUpdateJob(job);
		return new ResponseEntity<String>("Job added Successfully",HttpStatus.OK);
	}
	
	// Delete a particular Job details by fetching an jobid
	@RequestMapping(value="/deleteJob/{jobid}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteJob(@PathVariable("jobid") int jobid)
	{
		jobDAO.deleteJob(jobDAO.getParticularJob(jobid));
		return new ResponseEntity<String>("Job deleted Successfully",HttpStatus.OK);
	}
	
	// Update a particular Job details
	@RequestMapping(value="/updateJob/{jobid}", method=RequestMethod.PUT)
	public ResponseEntity<Job> updateJob(@PathVariable("jobid") int jobid, @RequestBody Job job)
	{
		Job updatejob = jobDAO.getParticularJob(jobid);
		updatejob.setQualification(job.getQualification());
		jobDAO.addOrUpdateJob(updatejob);
		return new ResponseEntity<Job>(updatejob,HttpStatus.OK);
	}
}




