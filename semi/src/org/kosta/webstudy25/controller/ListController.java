package org.kosta.webstudy25.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.kosta.webstudy25.model.QuestionBoardDAO;
import org.kosta.webstudy25.model.QuestionVO;


public class ListController  implements Controller {
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		String category=request.getParameter("category");
		//System.out.println(category);
		
		if(category.equals("se")) {
			request.setAttribute("list", QuestionBoardDAO.getInstance().getSEList());
		}else if(category.equals("jdbc")) {
			request.setAttribute("list", QuestionBoardDAO.getInstance().getJdbcList());	
		}else {
			request.setAttribute("list", QuestionBoardDAO.getInstance().getWebList());
		}
		
		
		request.setAttribute("url", "/board/list.jsp");		
		return "/template/layout.jsp";
	}
}







