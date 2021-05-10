package org.kosta.webstudy25.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy25.model.QuestionBoardDAO;
import org.kosta.webstudy25.model.QuestionVO;

public class WriteAnswerFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		String qno=request.getParameter("questionNo");
		QuestionVO vo=QuestionBoardDAO.getInstance().getPostingByNo(qno);
		request.setAttribute("vo", vo);
		request.setAttribute("url", "/board/writeAnswer.jsp");		
		return "/template/layout.jsp";
	}

}
