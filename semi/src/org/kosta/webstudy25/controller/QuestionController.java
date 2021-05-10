package org.kosta.webstudy25.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy25.model.QuestionBoardDAO;
import org.kosta.webstudy25.model.QuestionVO;

public class QuestionController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		ArrayList<QuestionVO> list
		=QuestionBoardDAO.getInstance().getPostingList();
		request.setAttribute("list", list);
		request.setAttribute("url", "/board/list.jsp");		
		return "/template/layout.jsp";
	}

}
