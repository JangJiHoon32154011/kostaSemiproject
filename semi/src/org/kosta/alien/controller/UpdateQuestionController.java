package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;

public class UpdateQuestionController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null||
				request.getMethod().equals("POST")==false){
			return "redirect:index.jsp";
		}	
		String qno=request.getParameter("qno");
		String title=request.getParameter("title");
		String questionContent=request.getParameter("questionContent");
		QuestionVO qvo=new QuestionVO(qno, title, questionContent);
		QuestionBoardDAO.getInstance().updateQuestion(qvo);
		System.out.println(qvo);
		return "redirect:index.jsp";
	}
}
