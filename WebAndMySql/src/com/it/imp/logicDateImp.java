package com.it.imp;

import java.util.List;

import com.it.entity.User;

public interface logicDateImp {

	public List<User> selectInfo();
	public void insertInfo(User user);
	public void deleteInfo(int id);
	public User selectId(int id);
	public void modifyInfo(User user);
	
	
}
