package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.alien.model.MemberDAO;

public class FindPasswordController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = null;
		password = MemberDAO.getInstance().findPassword(id, name, email);
		if (password == null) {// 조회 결과 없음
			request.setAttribute("url", "/member/findPassword-fail.jsp");
		}else {
			request.setAttribute("password", password);
			request.setAttribute("url", "/member/findPassword-pass.jsp");
		}
		// 아닐때 조건 반영
		// 아닐때 되돌아감
		
		return "/template/layout.jsp";
	}
}
