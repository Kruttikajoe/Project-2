package com.niit.collabbackend.DAO;

import java.util.List;

import com.niit.collabbackend.model.Forum;

public interface ForumDAO {

	public boolean addOrUpdateForum(Forum forum);

	public boolean deleteForum(Forum forum);

	public List<Forum> getListOfForum();

	public Forum getParticularForum(int forumid);

}
