package com.it.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.entity.User;
import com.it.service.logicDate;

public class InsertInfo extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			req.setCharacterEncoding("utf-8");
			String name = req.getParameter("name");
			String sex = req.getParameter("sex");
			String age = req.getParameter("age");
			String tel = req.getParameter("tel");
			String email = req.getParameter("email");
			String qq = req.getParameter("qq");
			
			logicDate ld = new logicDate();
			
			User user = new User();
			user.setName(name);
			user.setSex(sex);
			user.setAge(Integer.parseInt(age));
			user.setTel(tel);
			user.setEmail(email);
			user.setQq(qq);
			
			ld.insertInfo(user);
			
			resp.sendRedirect(req.getContextPath() + "/UserServlet");
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
			doGet(req, resp);
		}
}
