package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.AnswerDAO;
import org.kosta.alien.model.AnswerVO;
import org.kosta.alien.model.MemberVO;

public class OtherAnswerDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		
		String id=request.getParameter("id");
		
		int ano=Integer.parseInt(request.getParameter("ano"));
		
		String no=request.getParameter("ano");
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		System.out.println("check"+ano+ " "+ mvo.getId());
		
		System.out.println(id);
		if(mvo.getId().equals(id)==false) {
		
		
			
			AnswerDAO.getInstance().updateHit(no);	
			
		}
		AnswerVO avo=AnswerDAO.getInstance().getOtherDetailAnswer(ano);
		request.setAttribute("avo", avo);
		request.setAttribute("url", "/board/other-answer-detail.jsp");
		
		return "/template/layout.jsp";
	}

}
