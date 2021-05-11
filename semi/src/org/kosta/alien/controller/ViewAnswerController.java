package org.kosta.alien.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.AnswerDAO;
import org.kosta.alien.model.AnswerVO;
import org.kosta.alien.model.MemberVO;
import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;

public class ViewAnswerController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		int qno=Integer.parseInt(request.getParameter("qno"));
		String no=request.getParameter("qno");
		QuestionVO qvo=QuestionBoardDAO.getInstance().getPostingByNo(no);
		request.setAttribute("qvo", qvo);
		ArrayList<AnswerVO> list
		=AnswerDAO.getInstance().getAllAnswerList(qno);
		request.setAttribute("list", list);
		request.setAttribute("url", "/mypage/answerview.jsp");		
		return "/template/layout.jsp";
	}

}
