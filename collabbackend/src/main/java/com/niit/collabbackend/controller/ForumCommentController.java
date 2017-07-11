package com.niit.collabbackend.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collabbackend.DAO.ForumCommentDAO;
import com.niit.collabbackend.DAO.ForumDAO;
import com.niit.collabbackend.model.ForumComment;

@RestController

public class ForumCommentController {

	@Autowired
	HttpSession httpSession;

	@Autowired
	ForumCommentDAO forumCommentDAO;

	@Autowired
	ForumDAO forumDAO;

	@Autowired
	ForumComment forumComment;

	@PostMapping(value = "/forum/comment/{forumid}")
	public ResponseEntity<ForumComment> addForumComment(@PathVariable("forumid") int forumid,
			@RequestBody ForumComment forumComment) {
		int user_id = (int) httpSession.getAttribute("loggedInUserID");
		forumComment.setUser_id(user_id);
		forumComment.setForum_id(forumid);
		forumComment.setfComment_date(new Date());
		if (forumCommentDAO.addOrUpdateForumComment(forumComment) == true) {
			forumComment.setErrCode("200");
			forumComment.setErrMessage("Commented Successfully");
			return new ResponseEntity<ForumComment>(forumComment, HttpStatus.OK);
		} else {
			forumComment.setErrCode("404");
			forumComment.setErrMessage("Could not comment on the Blog");
			return new ResponseEntity<ForumComment>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(value = "/forum/comment/list/{forumid}")
	public ResponseEntity<List<ForumComment>> getListOfParticularForumComments(@PathVariable("forumid") int forumid) {
		if (forumDAO.getParticularForum(forumid) != null) {
			List<ForumComment> list = forumCommentDAO.getParticularForumCommentsList(forumid);
			return new ResponseEntity<List<ForumComment>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<ForumComment>>(HttpStatus.NO_CONTENT);
		}

	}

}
