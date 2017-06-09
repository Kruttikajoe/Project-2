package com.niit.collabbackend.DAO;

import java.util.List;

import com.niit.collabbackend.model.BlogComment;

public interface BlogCommentDAO {
	
	public boolean saveOrUpdateBlogComment(BlogComment blogComment);
	
	public boolean deleteBlogComment(BlogComment blogComment);
	
	public List<BlogComment> getListOfBlogComments();
	
	public BlogComment getParticularBlogComment(int blog_comment_id);


}
