package com.niit.collabbackend.DAO;

import java.util.List;

import com.niit.collabbackend.model.ForumComment;

public interface ForumCommentDAO {

	public boolean addOrUpdateForumComment(ForumComment forumComment);

	public boolean deleteForumComment(ForumComment forumComment);

	public ForumComment getParticularForumComment(int fComment_id);

	public List<ForumComment> getParticularForumCommentsList(int forum_id);
}
