package org.kosta.alien.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;

public class SearchController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String word = request.getParameter("word");
		ArrayList<QuestionVO> list
		=QuestionBoardDAO.getInstance().searchQuestion(word);
		request.setAttribute("list", list);
		System.err.println(list);
		request.setAttribute("url", "/board/list.jsp");		
		return "template/layout.jsp";
	}

}
