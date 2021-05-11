package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.AnswerDAO;
import org.kosta.alien.model.MemberVO;
import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;

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
		int qno2=Integer.parseInt(request.getParameter("questionNo"));
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		Boolean flag=AnswerDAO.getInstance().getUpdateCheck(mvo.getId(), qno2);
		if(flag) {
			request.setAttribute("url", "/board/writeAnswer.jsp");	
		}else {
			request.setAttribute("url", "/board/welcome.jsp");
		}
				
		return "/template/layout.jsp";
	}

}
