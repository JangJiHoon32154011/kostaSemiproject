package org.kosta.webstudy25.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy25.model.JAnswerDAO;
import org.kosta.webstudy25.model.JAnswerVO;
import org.kosta.webstudy25.model.QuestionBoardDAO;
import org.kosta.webstudy25.model.QuestionVO;

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
