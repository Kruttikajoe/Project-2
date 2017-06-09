package com.niit.collabbackend.DAO;

import java.util.List;

import com.niit.collabbackend.model.Blog;

public interface BlogDAO {
	
	public Blog getBlog(String id);
	public List<Blog> getAllBlogs();
	public boolean saveOrUpdate(Blog blog);

}
