package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.AnswerDAO;
import org.kosta.alien.model.AnswerVO;

public class OtherAnswerDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		
		int ano=Integer.parseInt(request.getParameter("ano"));
		AnswerVO avo=AnswerDAO.getInstance().getOtherDetailAnswer(ano);
		request.setAttribute("avo", avo);
		request.setAttribute("url", "/board/other-answer-detail.jsp");
		return "/template/layout.jsp";
	}

}
