package com.niit.collabbackend.DAO;

import java.util.List;

import com.niit.collabbackend.model.ForumComment;


public interface ForumCommentDAO {
	
public boolean saveOrUpdateForumComment(ForumComment forumComment);
	
	public boolean deleteForumComment(ForumComment  forumComment);
	
	public List<ForumComment> getListOfForumComments();
	
	public ForumComment getParticularForumComment(int forum_comment_id);

}
