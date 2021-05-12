package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.MemberDAO;
import org.kosta.alien.model.MemberVO;

public class ManageMemberDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		String id=request.getParameter("id");
		MemberVO vo=MemberDAO.getInstance().getMemberDetail(id);
		request.setAttribute("mvo", vo);
		request.setAttribute("url", "/manage/manageMemberDetail.jsp");
		return "/template/layout.jsp";
	}

}
