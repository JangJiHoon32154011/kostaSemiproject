package org.kosta.alien.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.AnswerDAO;
import org.kosta.alien.model.AnswerVO;
import org.kosta.alien.model.MemberDAO;
import org.kosta.alien.model.MemberVO;
import org.kosta.alien.model.PagingBean;
import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;

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
		AnswerVO avo=new AnswerVO(mvo.getId(), qno, contents);
		AnswerDAO.getInstance().Answer(avo);
		MemberDAO.getInstance().updateStamp(mvo.getId(), 1);
		int stampNo=MemberDAO.getInstance().checkStamp(mvo.getId());
		MemberDAO.getInstance().updateCoupon(mvo.getId(),stampNo);

		return "/index.jsp";
	}
}
