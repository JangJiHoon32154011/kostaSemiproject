package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.AnswerDAO;
import org.kosta.alien.model.AnswerVO;
import org.kosta.alien.model.MemberVO;

public class UpdateAnswerController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null||
				request.getMethod().equals("POST")==false){
			return "redirect:index.jsp";
		}	
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		String id=mvo.getId();
		String qno=request.getParameter("qno");
		String answerContent=request.getParameter("answerContent");
		//String ano=request.getParameter("ano");
		AnswerVO javo=new AnswerVO(id, qno, answerContent);
		AnswerDAO.getInstance().updateAnswer(javo);
		return "redirect:index.jsp";
	}

}
