package com.niit.collabbackend.DAO;

import java.util.List;

import com.niit.collabbackend.model.Users;

public interface UserDAO {

	public boolean addOrUpdateUser(Users user);

	public boolean deleteUser(Users user);

	public List<Users> getListOFUsers();

	public Users getParticularUser(int user_id);

}
