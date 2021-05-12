package org.kosta.alien.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.MemberDAO;
import org.kosta.alien.model.MemberVO;

public class ManageMemberFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null
				){
			return "redirect:index.jsp";
		}
		
		ArrayList<MemberVO> list= MemberDAO.getInstance().getMemberIdList();
		request.setAttribute("list", list);
		request.setAttribute("url", "/manage/manageMember.jsp");
		return "/template/layout.jsp";
	}

}