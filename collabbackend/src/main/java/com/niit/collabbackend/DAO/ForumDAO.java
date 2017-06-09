package com.niit.collabbackend.DAO;

import java.util.List;

import com.niit.collabbackend.model.Forum;

public interface ForumDAO {
	
	public boolean saveOrUpdate(Forum forum);
	
	public Forum getForum(String id);
	
	public List<Forum> getAllForums();
	

}
