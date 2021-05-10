package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.alien.model.MemberDAO;

public class SignUpController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		MemberDAO.getInstance().signUp(id, password, name, email);
		request.setAttribute("url", "/board/welcome.jsp");
		return "/template/layout.jsp";
	}
	
}
