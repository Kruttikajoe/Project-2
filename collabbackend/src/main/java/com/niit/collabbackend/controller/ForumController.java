package com.niit.collabbackend.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collabbackend.DAO.ForumDAO;
import com.niit.collabbackend.DAO.UserDAO;
import com.niit.collabbackend.model.Forum;

@RestController

public class ForumController {

	@Autowired
	ForumDAO forumDAO;

	@Autowired
	UserDAO userDAO;

	// To get the list of all the forums
	@RequestMapping(value = "/getListOfForum", method = RequestMethod.GET)
	public ResponseEntity<List<Forum>> getListOfForum() {
		List<Forum> forumlist = forumDAO.getListOfForum();
		return new ResponseEntity<List<Forum>>(forumlist, HttpStatus.OK);
	}

	// To get a particular Forum details using forum id
	@RequestMapping(value = "/getParticularForum/{forumid}", method = RequestMethod.GET)
	public ResponseEntity<Forum> getParticularForum(@PathVariable("forumid") int forumid) {
		Forum particularforum = forumDAO.getParticularForum(forumid);
		return new ResponseEntity<Forum>(particularforum, HttpStatus.OK);
	}

	// To add a particular Forum details in the DB
	@RequestMapping(value = "/addForum", method = RequestMethod.POST)
	public ResponseEntity<String> addForum(@RequestBody Forum forum, HttpSession httpSession) {
		int loggedInUserId = (int) httpSession.getAttribute("loggedInUserID");

		forum.setUser_id(loggedInUserId);

		if (userDAO.getParticularUser(loggedInUserId).getRole().equalsIgnoreCase("admin")) {
			forum.setStatus("APPROVED");
		} else {
			forum.setStatus("PENDING");
		}

		forum.setCreate_date(new Date());
		if (forumDAO.addOrUpdateForum(forum)) {
			forum.setErrCode("200");
			forum.setErrMessage("Forum added Successfully");
			return new ResponseEntity<String>("Forum added successfully", HttpStatus.OK);
		} else {
			forum.setErrCode("404");
			forum.setErrMessage("Problem occured while creating the Forum. Please contact the Admin");
			return new ResponseEntity<String>("Forum not created", HttpStatus.OK);
		}

	}

	// To delete a particular Forum from the DB
	@RequestMapping(value = "/deleteForum/{forumid}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteForum(@PathVariable("forumid") int forumid) {
		forumDAO.deleteForum(forumDAO.getParticularForum(forumid));
		return new ResponseEntity<String>("Forum deleted successfully", HttpStatus.OK);
	}

	/*
	 * To update a particular Forum Date will not be displayed as YYYY-MM-DD in
	 * postman since the updateblog date property is not temporal
	 */
	@RequestMapping(value = "/updateForum/{forumid}", method = RequestMethod.PUT)
	public ResponseEntity<Forum> updateForum(@PathVariable("forumid") int forumid, @RequestBody Forum forum) {
		Forum updateforum = forumDAO.getParticularForum(forumid);
		updateforum.setCreate_date(forum.getCreate_date());
		forumDAO.addOrUpdateForum(updateforum);
		return new ResponseEntity<Forum>(updateforum, HttpStatus.OK);
	}
}
