package org.kosta.webstudy25.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy25.model.JAnswerDAO;
import org.kosta.webstudy25.model.JAnswerVO;
import org.kosta.webstudy25.model.MemberVO;

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
		JAnswerVO javo=new JAnswerVO(id, qno, answerContent);
		JAnswerDAO.getInstance().updateAnswer(javo);
		return "redirect:index.jsp";
	}

}
