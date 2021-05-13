package org.kosta.alien.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.MemberVO;
import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;

public class AddQuestionController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		String title=request.getParameter("title");
		String category=request.getParameter("category");
		String contents=request.getParameter("contents");
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		
		QuestionVO vo=new QuestionVO(title, mvo.getId(), contents, category);
		QuestionBoardDAO.getInstance().AddQuestion(vo);
		
		ArrayList<QuestionVO> list = QuestionBoardDAO.getInstance().getPostingList();
		request.setAttribute("list", list);
		
		request.setAttribute("url", "/board/welcome.jsp");		
		return "/template/layout.jsp";
	}

}
