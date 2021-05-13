package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.MemberDAO;
import org.kosta.alien.model.MemberVO;

public class UpdateMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null||
				request.getMethod().equals("POST")==false){
			return "redirect:index.jsp";
		}	
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		String id=mvo.getId();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		MemberDAO.getInstance().updateMember(id,name,password,email);
		request.setAttribute("url", "/board/mypage.jsp");
		return "redirect:member/updatesuccess.jsp";
	}

}
