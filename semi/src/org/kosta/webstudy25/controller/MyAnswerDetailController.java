package org.kosta.webstudy25.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy25.model.AnswerBoardDAO;
import org.kosta.webstudy25.model.AnswerVO;
import org.kosta.webstudy25.model.JAnswerDAO;
import org.kosta.webstudy25.model.JAnswerVO;
import org.kosta.webstudy25.model.MemberAnswerBoardDAO;
import org.kosta.webstudy25.model.MemberAnswerVO;
import org.kosta.webstudy25.model.MemberVO;

public class MyAnswerDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		int qno=Integer.parseInt(request.getParameter("questionNo"));
		//AnswerDAO 로 가서 마무리 할 것
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		String id=mvo.getId();
		JAnswerVO javo=JAnswerDAO.getInstance().getMyDetailAnswer(id, qno);	
		request.setAttribute("javo", javo);
		request.setAttribute("url", "/board/myAnswer-detail.jsp");
		System.out.println(javo);
		return "/template/layout.jsp";
	}

}