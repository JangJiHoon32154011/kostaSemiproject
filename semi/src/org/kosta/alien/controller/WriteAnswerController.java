package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.AnswerDAO;
import org.kosta.alien.model.AnswerVO;
import org.kosta.alien.model.MemberAnswerVO;
import org.kosta.alien.model.MemberVO;

public class WriteAnswerController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		String contents=request.getParameter("content");
		String qno=request.getParameter("questionNo");
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");	
		AnswerVO javo=new AnswerVO(mvo.getId(), qno, contents);
		AnswerDAO.getInstance().Answer(javo);
		
		request.setAttribute("url", "/board/list.jsp");		
		return "/template/layout.jsp";
	}
}
