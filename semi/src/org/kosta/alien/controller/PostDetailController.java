package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;

public class PostDetailController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		// 로그인이 안 되어있을 때, 처리->home
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		// question NO 받기
	      String questionNo=request.getParameter("questionNo");
	      // vo NO에 따른 문제 받아오기

	      QuestionVO vo=QuestionBoardDAO.getInstance().getPostingByNo(questionNo);
	      System.out.println("vo가 picture 받아오는지 확인"+vo);
	      request.setAttribute("qvo", vo);
	      request.setAttribute("url", "/board/post-detail.jsp");    

	      return "/template/layout.jsp";
	}
	
}
