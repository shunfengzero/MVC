package com.it.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.it.entity.User;
import com.it.jdbcutil.JDBCUtil;
import com.it.jdbcutil.NewUtil;
public class UserDao {
	//查询
	public List<User> findALl() {
		
			//Connection conn = JDBCUtil.getConnection();
			List<User> list = null;
			QueryRunner qr = NewUtil.getQueryRunner();
			String sql = "select * from user";
		
		
			try {
				list = qr.query(sql, new BeanListHandler<User>(User.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		
			return list;
			
	}
	
	//插入
	public void insert(User user) {
	
		
		QueryRunner qr = NewUtil.getQueryRunner();
		String sql = "insert into user(name,sex,age,tel,email,qq) values(?,?,?,?,?,?)";
		
		try {
			qr.update(sql, new Object[]{user.getName(), user.getSex(),user.getAge(), user.getTel(), user.getEmail(), user.getQq()} );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	/*	try {
			DbUtils.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	}
	
	//删除
	public void delete(int id) {   
		//Connection conn = JDBCUtil.getConnection();
		
		QueryRunner qr = NewUtil.getQueryRunner();
		String sql = "delete from user where id = ?";
		try {
			qr.update(sql,id);
			
			//DbUtils.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//修改

	public void modify(User user) {
		//Connection conn = JDBCUtil.getConnection();
		
		QueryRunner qr = NewUtil.getQueryRunner();
		String sql = "update user set  name=?,sex=?, tel=? , age=?, email=?,qq=? where id = ?";
		
		try {
			qr.update(sql, new Object[]{user.getName(),user.getSex(),
					user.getTel(),user.getAge(),user.getEmail()	,user.getQq()
					,user.getId()});
	
			//DbUtils.close(conn);
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	//查询某个id
		public User findInfoById(int id) {
			
			//Connection conn = JDBCUtil.getConnection();
			User user = new User();
			QueryRunner qr = NewUtil.getQueryRunner();
			String sql = "select * from user where id = ?";
			
			
				try {
					user = qr.query(sql, new BeanHandler<User>(User.class),id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
			/*	try {
					DbUtils.close(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	*/
				return user;		
		}
		
		//查询总的页数
		public int selectAllPage() {
			int p1 = 0;
			int p2 = 0;
			//Connection conn = JDBCUtil.getConnection();
			List<User> list = null;
			QueryRunner qr = NewUtil.getQueryRunner();
			String sql = "select * from user";
		
		
			try {
				list = qr.query(sql, new BeanListHandler<User>(User.class));
				int infoNumber = list.size();
				
				 p1 = infoNumber % 3;
				 p2 = infoNumber / 3;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			if (p1 != 0) {
				p2 = p2 + 1;
			}
			return p2;
				
		}
		
		//查询指定页的数据
		public List<User> limitUser(int myPage) {
			List<User> list = null;
			QueryRunner qr = NewUtil.getQueryRunner();
			int pageSize = 3;
			int page = (myPage - 1) * 3;
			
			String sql = "select * from user limit ? , ?";
			

			try {
				list = qr.query(sql, new BeanListHandler<User>(User.class),page,pageSize);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	
			return list;
			
		}
}



























