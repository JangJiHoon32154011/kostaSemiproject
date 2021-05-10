package org.kosta.alien.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;


public class ListController2  implements Controller {
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {						
		ArrayList<QuestionVO> list
		=QuestionBoardDAO.getInstance().getPostingList();		
		request.setAttribute("list", list);
		request.setAttribute("url", "/board/list.jsp");		
		return "/template/layout1.jsp";
	}
}







