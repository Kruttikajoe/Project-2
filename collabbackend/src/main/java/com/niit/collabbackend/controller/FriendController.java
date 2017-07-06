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

import com.niit.collabbackend.DAO.FriendDAO;
import com.niit.collabbackend.model.Friend;

@RestController

public class FriendController {
	
	@Autowired
	FriendDAO friendDAO;
	
	// Controller to get the List of Friends
	@RequestMapping(value="/getListOfFriends", method=RequestMethod.GET)
	public ResponseEntity<List<Friend>> getListOfFriends()
	{
		List<Friend> friendlist = friendDAO.getListOfFriend();
		return new ResponseEntity<List<Friend>>(friendlist,HttpStatus.OK);
	}
	
	// Controller to add a friend
	@RequestMapping(value="/addFriend", method=RequestMethod.POST)
	public ResponseEntity<String> addFriend(@RequestBody Friend friend)
	{
		friend.setStatus("PENDING");
		friendDAO.addOrUpdateFriend(friend);
		return new ResponseEntity<String>("Friend added successfully",HttpStatus.OK);
	}
	
	// Controller to delete a friend
	@RequestMapping(value="/deleteFriend/{friendid}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteFriend(@PathVariable("friendid") int friendid)
	{
		friendDAO.deleteFriend(friendDAO.getParticularFriend(friendid));
		return new ResponseEntity<String>("Friend deleted Successfully",HttpStatus.OK);
	}
	
	// Controller to update a friend
	@RequestMapping(value="/updateFriend/{friendid}", method=RequestMethod.PUT)
	public ResponseEntity<Friend> updateFriend(@PathVariable("friendid") int friendid, @RequestBody Friend friend)
	{
		Friend updatefriend = friendDAO.getParticularFriend(friendid);
		//updatefriend.setUser_id(friend.getUser_id());
		updatefriend.setStatus(friend.getStatus());
		friendDAO.addOrUpdateFriend(updatefriend);
		return new ResponseEntity<Friend>(updatefriend,HttpStatus.OK);
	}

}
