package com.niit.collabbackend.DAO;

import java.util.List;

import com.niit.collabbackend.model.Users;

public interface UserDAO {
	
	public boolean saveOrUpdate(Users user);

	
	public List<Users> list();
	
	public boolean delete(Users user);

	public Users get(String email);


	public List<Users> getListOFUsers();


	public Object getParticularUser(int userid);


	public void deleteUser(Object particularUser);

}
