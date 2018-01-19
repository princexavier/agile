package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.Insert_impl;
import com.pojo.register_pojo;

@WebServlet("/Register_controller")
public class Register_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    register_pojo reg = new register_pojo();
	    reg.setUsername(request.getParameter("username"));
	    reg.setEmail(request.getParameter("email"));
	    reg.setPassword(request.getParameter("password"));
	    Insert_impl implem = new Insert_impl();
	    String button = request.getParameter("buttonValue");
	    if(button.equals("register")){
	    	implem.insert(reg);
	    } 
	    HttpSession session = request.getSession();
	    session.setAttribute("userKey", reg);
	    RequestDispatcher rd =request.getRequestDispatcher("login.jsp");
	    rd.forward(request, response);
	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doGet(request, response);
	}

}
