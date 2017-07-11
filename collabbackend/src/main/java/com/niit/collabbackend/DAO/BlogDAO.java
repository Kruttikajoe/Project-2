package com.niit.collabbackend.DAO;

import java.util.List;

import com.niit.collabbackend.model.Blog;

public interface BlogDAO {

	public boolean addOrUpdateBlog(Blog blog);

	public boolean deleteBlog(Blog blog);

	public List<Blog> getListOfBlog();

	public Blog getParticularBlog(int blogid);

}
