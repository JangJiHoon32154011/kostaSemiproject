package org.kosta.webstudy25.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy25.model.JAnswerDAO;
import org.kosta.webstudy25.model.MemberAnswerBoardDAO;

public class DeleteAnswerController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null||
				request.getMethod().equals("POST")==false){
			return "redirect:ListController.do";
		}
		int ano=Integer.parseInt(request.getParameter("ano"));
		JAnswerDAO.getInstance().deleteMyAnswer(ano);
		return "redirect:MypageController.do";
	}

}
