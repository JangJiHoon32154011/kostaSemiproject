package org.kosta.alien.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.alien.model.PagingBean;
import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;

public class HomeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int getTotalQuestionCount = QuestionBoardDAO.getInstance().getTotalQuestionCount();
		String pageNo = request.getParameter("pageNo");
		PagingBean pagingBean = null;
		if (pageNo == null) {
			pagingBean = new PagingBean(getTotalQuestionCount);
		} else {
			pagingBean = new PagingBean(getTotalQuestionCount, Integer.parseInt(pageNo));
		}
		request.setAttribute("pagingBean", pagingBean);
		ArrayList<QuestionVO> list = QuestionBoardDAO.getInstance().getPostingList(pagingBean);
		request.setAttribute("list", list);
		
		request.setAttribute("url", "/board/welcome.jsp");		
		return "/template/layout.jsp";
	}

}
