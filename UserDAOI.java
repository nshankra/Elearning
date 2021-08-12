package com.elearning.daos;

import java.util.List;

import com.elearning.entitites.User1;

public interface UserDAOI {
	public int register(User1 user);
	public List<User1> getAllUsers();
}
