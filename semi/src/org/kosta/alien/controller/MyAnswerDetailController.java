package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.AnswerDAO;
import org.kosta.alien.model.AnswerVO;
import org.kosta.alien.model.MemberVO;
import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;

public class MyAnswerDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		int qno=Integer.parseInt(request.getParameter("questionNo"));

		QuestionVO qvo=QuestionBoardDAO.getInstance().getPostingByNo(request.getParameter("questionNo"));
		request.setAttribute("qvo", qvo);
		System.out.println(qvo);
		
		//AnswerDAO 로 가서 마무리 할 것
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		String id=mvo.getId();
		AnswerVO avo=AnswerDAO.getInstance().getMyDetailAnswer(id, qno);	
		request.setAttribute("avo", avo);
		request.setAttribute("url", "/board/myAnswer-detail.jsp");
		System.out.println(avo);
		return "/template/layout.jsp";
	}

}