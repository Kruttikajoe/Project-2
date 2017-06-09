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
import com.niit.collabbackend.model.Users;

@RestController

public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	Users user;
	
	// Get the list of all Users
	@RequestMapping(value="/getUsers", method=RequestMethod.GET)
	public ResponseEntity<List<Users>> getUsers()
	{
		List<Users> userlists = userDAO.getListOFUsers();
		return new ResponseEntity<List<Users>>(userlists,HttpStatus.OK);
	}
	
	// Add a particular User
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody Users user)
	{
		userDAO.saveOrUpdate(user);
		return new ResponseEntity<String>("User added successfully",HttpStatus.OK);
	}
	
	// Delete a particular User by fetching an userid
	@RequestMapping(value="/deleteUser/{userid}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("userid") int userid)
	{
		userDAO.deleteUser(userDAO.getParticularUser(userid));
		return new ResponseEntity<String>("User deleted Successfully",HttpStatus.OK);
	}
	
	// Update a particular User
	@RequestMapping(value="/updateUser/{userid}", method=RequestMethod.PUT)
	public ResponseEntity<Users> updateUser(@PathVariable("userid") int userid, @RequestBody Users user)
	{
		Users updateuser = (Users)userDAO.getParticularUser(userid);
		updateuser.setEmail(user.getEmail());
		userDAO.saveOrUpdate(updateuser);
		return new ResponseEntity<Users>(updateuser,HttpStatus.OK);
	}
}





