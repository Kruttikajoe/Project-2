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

import com.niit.collabbackend.DAO.BlogDAO;
import com.niit.collabbackend.DAO.UserDAO;
import com.niit.collabbackend.model.Blog;
import com.niit.collabbackend.model.Users;

@RestController

public class BlogController {

	@Autowired
	BlogDAO blogDAO;

	@Autowired
	Blog blog;

	@Autowired
	Users user;

	@Autowired
	UserDAO userDAO;

	// To get the list of all the blog objects
	@RequestMapping(value = "/getListOfBlog", method = RequestMethod.GET)
	public ResponseEntity<List<Blog>> getListOfBlog() {
		List<Blog> bloglist = blogDAO.getListOfBlog();
		return new ResponseEntity<List<Blog>>(bloglist, HttpStatus.OK);
	}

	/*
	 * To get a particular Blog details using blog id In postman, blog details
	 * are only displayed.
	 */
	@RequestMapping(value = "/getParticularBlog/{blogid}", method = RequestMethod.GET)
	public ResponseEntity<Blog> getParticularBlog(@PathVariable("blogid") int blogid) {
		Blog particularblog = blogDAO.getParticularBlog(blogid);
		return new ResponseEntity<Blog>(particularblog, HttpStatus.OK);
	}

	/*
	 * To get a particular user details with blogid In postman the user will
	 * display the blog and forum details along with it
	 */
	@RequestMapping(value = "/getUserDetailsWithBlogid/{blogid}", method = RequestMethod.GET)
	public ResponseEntity<Users> getUserDetailsWithBlogid(@PathVariable("blogid") int blogid) {
		Blog blogwithuser = blogDAO.getParticularBlog(blogid);
		return new ResponseEntity<Users>(blogwithuser.getUser(), HttpStatus.OK);
	}

	// To add a particular blog details in the DB
	@RequestMapping(value = "/addBlog", method = RequestMethod.POST)
	public ResponseEntity<String> addBlog(@RequestBody Blog blog) {
		System.out.println(blog.getUser());
		blog.setStatus("PENDING");
		blogDAO.addOrUpdateBlog(blog);
		return new ResponseEntity<String>("Blog added successfully", HttpStatus.OK);
	}

	// To delete a particular blog from the DB
	@RequestMapping(value = "/deleteBlog/{blogid}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteBlog(@PathVariable("blogid") int blogid) {
		blogDAO.deleteBlog(blogDAO.getParticularBlog(blogid));
		return new ResponseEntity<String>("Blog deleted successfully", HttpStatus.OK);
	}

	/*
	 * To update a particular blog Date will not be displayed as YYYY-MM-DD in
	 * postman since the updateblog date property is not temporal
	 */
	@RequestMapping(value = "/updateBlog/{blogid}", method = RequestMethod.PUT)
	public ResponseEntity<Blog> updateBlog(@PathVariable("blogid") int blogid, @RequestBody Blog blog) {
		Blog updateblog = blogDAO.getParticularBlog(blogid);
		// updateblog.setBlog_content(blog.getBlog_content());
		updateblog.setCreate_date(blog.getCreate_date());
		blogDAO.addOrUpdateBlog(updateblog);
		return new ResponseEntity<Blog>(updateblog, HttpStatus.OK);
	}
}
