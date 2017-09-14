package com.it.imp;

import java.util.List;

import com.it.entity.User;

public interface UserDaoImp {
	
	public List<User> findALl();
	public void insert(User user);
	public void delete(int id);
	public void modify(User user);
	public User findInfoById(int id);
	
	
}
