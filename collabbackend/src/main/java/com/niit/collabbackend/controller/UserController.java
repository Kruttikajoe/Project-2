package com.niit.collabbackend.controller;

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

import com.niit.collabbackend.DAO.UserDAO;
import com.niit.collabbackend.model.Users;

@RestController

public class UserController {
	@Autowired
	UserDAO userDAO;

	@Autowired
	Users user;

	/*
	 * Get the list of all Users
	 * Along with the list of users it returns the list of blog and forum associated with it(OneToMany)
	 */
	@RequestMapping(value="/getListOfUsers", method=RequestMethod.GET)
	public ResponseEntity<List<Users>> getUsers()
	{
		List<Users> userlists = userDAO.getListOFUsers();
		if(userlists.isEmpty()){
			return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Users>>(userlists,HttpStatus.OK);
	}
	
	/*
	 * Returns the list of blogs associated with a particular user
	 */
	/*@RequestMapping(value="/getBlogListWithUserid/{userid}", method=RequestMethod.GET)
	public ResponseEntity<List<Blog>> getBlogListWithUserid(@PathVariable("userid") int userid)
	{
		Users bloguser = userDAO.getParticularUser(userid);
		List<Blog> blog = bloguser.getBlog();
		return new ResponseEntity<List<Blog>>(blog,HttpStatus.OK);
	}*/
	
	// Add a particular User
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public ResponseEntity<Users> addUser(@RequestBody Users user)
	{
		if(userDAO.getParticularUser(user.getUser_id())==null){
			user.setStatus("PENDING");
			user.setIsOnline("NO");
			if(userDAO.addOrUpdateUser(user)){
				user.setErrCode("200");
				user.setErrMessage("Thank you for registering with us. You've been registered as "+user.getRole());	
			}
			else{
				user.setErrCode("404");
				user.setErrMessage("Operation not successful. Please contact the admin for further details");
			}
			return new ResponseEntity<Users>(user,HttpStatus.OK);
		}
		else{
			user.setErrCode("404");
			user.setErrMessage("User already exist with id : " + user.getUser_id());
			return new ResponseEntity<Users>(user,HttpStatus.OK);
		}
		
	}
	
	// Delete a particular User by fetching an userid
	@RequestMapping(value="/deleteUser/{userid}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("userid") int userid)
	{
		userDAO.deleteUser(userDAO.getParticularUser(userid));
		return new ResponseEntity<String>("User deleted Successfully",HttpStatus.OK);
	}
	
	/*
	 * Update a particular User
	 * Returns the updated user object along with the associated blog and user
	 */
	@RequestMapping(value="/updateUser/{userid}", method=RequestMethod.PUT)
	public ResponseEntity<Users> updateUser(@PathVariable("userid") int userid, @RequestBody Users user)
	{
		Users updateuser = userDAO.getParticularUser(userid);
		//updateuser.setEmail(user.getEmail());
		System.out.println(user.getUser_id());
		updateuser.setUser_id(user.getUser_id());
		userDAO.addOrUpdateUser(updateuser);
		return new ResponseEntity<Users>(updateuser,HttpStatus.OK);
	}
	
	/*
	 * To authenticate the User
	 */
	@RequestMapping(value="/authenticateUser", method=RequestMethod.POST)
	public ResponseEntity<Users> authenticateUser(@RequestBody Users user,HttpSession httpSession)
	{
		Users validateuser = userDAO.validateUser(user.getEmail(), user.getPassword());
		if(validateuser==null){
			validateuser = new Users();
			validateuser.setErrCode("404");
			validateuser.setErrMessage("Invalid Credentials.Please enter valid credentials");
			return new ResponseEntity<Users>(validateuser,HttpStatus.UNAUTHORIZED);
		}
		else{
			validateuser.setErrCode("200");
			validateuser.setErrMessage("Valid Credentials. Logged In successfully");
			httpSession.setAttribute("loggedInUserID", validateuser.getUser_id());
			httpSession.setAttribute("loggedInUsername", validateuser.getName());
			httpSession.setAttribute("loggedInUserRole", validateuser.getRole());
			validateuser.setIsOnline("YES");
			userDAO.addOrUpdateUser(validateuser);
			return new ResponseEntity<Users>(validateuser,HttpStatus.OK);
		}
		
	}
	
	/*
	 * logout a particular user
	 */
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ResponseEntity<Users> logout(HttpSession httpSession)
	{
		int loggedInUserID = (int) httpSession.getAttribute("loggedInUserID");
		Users user = userDAO.getParticularUser(loggedInUserID);
		user.setIsOnline("NO");
		httpSession.invalidate();
		user.setErrCode("200");
		user.setErrMessage("Logged Out Successfully");
		userDAO.addOrUpdateUser(user);
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}
}
