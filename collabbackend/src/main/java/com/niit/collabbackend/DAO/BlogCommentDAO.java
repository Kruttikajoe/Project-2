package com.niit.collabbackend.DAO;

import java.util.List;

import com.niit.collabbackend.model.BlogComment;

public interface BlogCommentDAO {

	public boolean addOrUpdateBlogComment(BlogComment blogComment);

	public boolean deleteBlogComment(BlogComment blogComment);

	public BlogComment getParticulatBlogComment(int bComment_id);

	public List<BlogComment> getParticularBlogCommentsList(int blog_id);

}
