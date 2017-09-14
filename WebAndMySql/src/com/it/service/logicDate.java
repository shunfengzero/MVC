package com.it.service;

import java.util.List;

import com.it.dao.UserDao;
import com.it.entity.User;

public class logicDate {
	
	UserDao dao = new UserDao();
	
	//查询用户信息
	public List<User> selectInfo(int myPage) {
		
		//List<User> list = dao.findALl();
		List<User> list = dao.limitUser(myPage);
		return list;
	}

	//插入用户信息
	public void insertInfo(User user) {
	
		
		try {
			dao.insert(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("插入的信息有误，请重新插入");
		}
		
	}
	
	//删除用户信息
	public void deleteInfo(int id) {
		
		try {
			
			dao.delete(id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("删除失败");
		}
	}
	
	//查询某个信息
	public User selectId(int id) {
		User user = new User();
		try {
			user = dao.findInfoById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("id不存在");
		}
		
		return user;
	}
	
	//修改某个用户信息
	public void modifyInfo(User user) {
		
		try {
			
			dao.modify(user);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("修改失败");
		}
		
		
		
	}
	//查询总的页数
	public int allPage() {
		
		
		int ap;
		try {
			ap = dao.selectAllPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("总的页数获取失败");
		}
		
		return ap;
	}
	
	//获取指定页
	public int mP(String page) {
			
		int mps = 1;
		
		if (page != null) {
			 mps = Integer.parseInt(page);
		}
		return mps;
		
	}
	
	
}
