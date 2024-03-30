package com.poly.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.poly.service.impl.UserServiceImpl;
import com.poly.constant.SessionAttr;
import com.poly.entity.User;
import com.poly.service.UserService;

@WebServlet(urlPatterns = { "/login", "/logout", "/signup" })
public class UserController extends HttpServlet {

	private static final long serialVersionUID = -5860351843059541642L;

	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			doGetLogin(req, resp);
			break;
		case "/signup":
			doGetSignUp(req, resp);
			break;
		case "/logout":
			doGetLogOut(session, req, resp);
			break;
		
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			doPostLogin(session, req, resp);
			break;
		case "/signup":
			doPostSignUp(session, req, resp);
			break;
		}
	}
	
	//login
	private void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
	}
	
	private void doGetSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/signup.jsp").forward(req, resp);
	}
	
	private void doGetLogOut(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session.removeAttribute(SessionAttr.CURRENT_USER);
		resp.sendRedirect("index");
	}

	private void doPostLogin(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = userService.login(username, password);
		
		if(user != null) {
			session.setAttribute(SessionAttr.CURRENT_USER, user);
			resp.sendRedirect("index");
		}else {
			resp.sendRedirect("login");
		}
	}
	
	private void doPostSignUp(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String username = req.getParameter("username");
	    String password = req.getParameter("password");
	    String email = req.getParameter("email");

	    User user = userService.create(username, password, email);

	    if (user != null) {
	        session.setAttribute(SessionAttr.CURRENT_USER, user);
	        resp.sendRedirect("index");
	    } else {
	        resp.sendRedirect("signup");
	    }
	}

}
