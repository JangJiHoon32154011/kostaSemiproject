package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.MemberDAO;
import org.kosta.alien.model.MemberVO;

public class UpdateMemberFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		System.out.println(mvo);
		if(session==null||mvo==null){
			return "redirect:index.jsp";
		}
		
		request.setAttribute("url", "/mypage/UpdateMember.jsp");
		return "/template/layout_mypage.jsp";
	}

}
