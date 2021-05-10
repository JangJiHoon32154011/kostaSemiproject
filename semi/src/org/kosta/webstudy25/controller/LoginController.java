package org.kosta.webstudy25.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy25.model.MemberDAO;
import org.kosta.webstudy25.model.MemberVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberVO mvo = MemberDAO.getInstance().login(id, password);
		if (mvo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("mvo", mvo);	
			System.out.println(session.getAttribute("mvo"));
			return "redirect:index.jsp";
		} else {			
			return "redirect:member/login-fail.jsp";		
		}
	}

}




