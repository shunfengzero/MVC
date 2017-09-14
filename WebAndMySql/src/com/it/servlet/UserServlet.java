package com.it.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.runner.Request;

import com.it.dao.UserDao;
import com.it.entity.Page;
import com.it.entity.User;
import com.it.service.logicDate;

public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		req.setCharacterEncoding("utf-8");
		Page p = new Page();
		logicDate ld = new logicDate();
		int myPage;
		String myPages = req.getParameter("point");
		
		p.setSelectPage(ld.mP(myPages));
		myPage = p.getSelectPage();
		
		List<User> list = ld.selectInfo(myPage);
		p.setPageCount(ld.allPage());		
		req.setAttribute("pages", p);
		req.setAttribute("list", list);
		//req.setAttribute("point", myPage);
		req.getRequestDispatcher("/selectAll.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
