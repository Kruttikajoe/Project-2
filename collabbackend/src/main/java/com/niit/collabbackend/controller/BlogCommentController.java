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

import com.niit.collabbackend.DAO.BlogCommentDAO;
import com.niit.collabbackend.DAO.BlogDAO;
import com.niit.collabbackend.model.BlogComment;

@RestController

public class BlogCommentController {

	@Autowired
	BlogCommentDAO blogCommentDAO;

	@Autowired
	BlogDAO blogDAO;

	@Autowired
	HttpSession httpSession;

	// The below mentioned mappings are of Blog Comments

	@PostMapping(value = "/addBlogComment/{blogid}")
	public ResponseEntity<BlogComment> addBlogComment(@PathVariable("blogid") int blogid,
			@RequestBody BlogComment blogComment, HttpSession httpSession) {
		int user_id = (int) httpSession.getAttribute("loggedInUserID");
		blogComment.setUser_id(user_id);
		blogComment.setBlog_id(blogid);
		blogComment.setbComment_date(new Date());
		if (blogCommentDAO.addOrUpdateBlogComment(blogComment) == true) {
			blogComment.setErrCode("200");
			blogComment.setErrMessage("Commented Successfully");
			return new ResponseEntity<BlogComment>(blogComment, HttpStatus.OK);
		} else {
			blogComment.setErrCode("404");
			blogComment.setErrMessage("Could not comment on the Blog");
			return new ResponseEntity<BlogComment>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(value = "/blog/comments/list/{blogid}")
	public ResponseEntity<List<BlogComment>> getListOfParticularBlogComments(@PathVariable("blogid") int blogid) {
		if (blogDAO.getParticularBlog(blogid) != null) {
			List<BlogComment> list = blogCommentDAO.getParticularBlogCommentsList(blogid);
			return new ResponseEntity<List<BlogComment>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<BlogComment>>(HttpStatus.NO_CONTENT);
		}
	}

}
