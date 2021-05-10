package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.AnswerDAO;
import org.kosta.alien.model.AnswerVO;
import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;

public class UpdateQuestionFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		int questionNo=Integer.parseInt(request.getParameter("questionNo"));
		QuestionVO qvo=QuestionBoardDAO.getInstance().getQuestionByQuestionNo(questionNo);
		request.setAttribute("qvo", qvo);
		request.setAttribute("url", "/board/updateQuestion.jsp");
		return "/template/layout.jsp";
	}

}
