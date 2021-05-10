package org.kosta.webstudy25.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy25.model.AnswerVO;
import org.kosta.webstudy25.model.JAnswerDAO;
import org.kosta.webstudy25.model.JAnswerVO;
import org.kosta.webstudy25.model.MemberAnswerVO;
import org.kosta.webstudy25.model.MemberVO;

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
		JAnswerVO javo=new JAnswerVO(mvo.getId(), qno, contents);
		JAnswerDAO.getInstance().Answer(javo);
		
		request.setAttribute("url", "/board/list.jsp");		
		return "/template/layout.jsp";
	}
}
