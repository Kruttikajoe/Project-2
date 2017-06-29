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

import com.niit.collabbackend.DAO.UserDAO;
import com.niit.collabbackend.model.Blog;
import com.niit.collabbackend.model.Users;

@RestController

public class UserController {
	@Autowired
	UserDAO userDAO;

	@Autowired
	Users user;

	/*
	 * Get the list of all Users Along with the list of users it returns the
	 * list of blog and forum associated with it(OneToMany)
	 */
	@RequestMapping(value = "/getListOfUsers", method = RequestMethod.GET)
	public ResponseEntity<List<Users>> getUsers() {
		List<Users> userlists = userDAO.getListOFUsers();
		if (userlists.isEmpty()) {
			return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Users>>(userlists, HttpStatus.OK);
	}

	/*
	 * Returns the list of blogs associated with a particular user
	 */
	@RequestMapping(value = "/getBlogListWithUserid/{userid}", method = RequestMethod.GET)
	public ResponseEntity<List<Blog>> getBlogListWithUserid(@PathVariable("userid") int userid) {
		Users bloguser = userDAO.getParticularUser(userid);
		List<Blog> blog = bloguser.getBlog();
		return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
	}

	// Add a particular User
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody Users user) {
		user.setStatus("PENDING");
		user.setIsOnline("NO");
		userDAO.addOrUpdateUser(user);
		return new ResponseEntity<String>("User added successfully", HttpStatus.OK);
	}

	// Delete a particular User by fetching an userid
	@RequestMapping(value = "/deleteUser/{userid}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("userid") int userid) {
		userDAO.deleteUser(userDAO.getParticularUser(userid));
		return new ResponseEntity<String>("User deleted Successfully", HttpStatus.OK);
	}

	/*
	 * Update a particular User Returns the updated user object along with the
	 * associated blog and user
	 */
	@RequestMapping(value = "/updateUser/{userid}", method = RequestMethod.PUT)
	public ResponseEntity<Users> updateUser(@PathVariable("userid") int userid, @RequestBody Users user) {
		Users updateuser = userDAO.getParticularUser(userid);
		// updateuser.setEmail(user.getEmail());
		System.out.println(user.getUserid());
		updateuser.setUserid(user.getUserid());
		userDAO.addOrUpdateUser(updateuser);
		return new ResponseEntity<Users>(updateuser, HttpStatus.OK);
	}

}
