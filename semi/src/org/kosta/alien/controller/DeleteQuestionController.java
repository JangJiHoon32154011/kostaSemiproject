package org.kosta.alien.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy25.model.QuestionBoardDAO;

public class DeleteQuestionController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null
				){
			return "redirect:ListController.do";
		}
		int questionNo=Integer.parseInt(request.getParameter("questionNo"));
		QuestionBoardDAO.getInstance().deleteQuestion(questionNo);
		
		return "redirect:index.jsp";
	}

}
