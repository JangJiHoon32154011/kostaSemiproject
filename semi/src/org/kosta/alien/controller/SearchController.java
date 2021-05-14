package org.kosta.alien.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.PagingBean;
import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;

public class SearchController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String word = request.getParameter("word");

		// <paging>
		int getTotalSearchedQuestionCountByWord = QuestionBoardDAO.getInstance()
				.getTotalSearchedQuestionCountByWord(word);
		String pageNo = request.getParameter("pageNo");
		PagingBean pagingBean = null;
		if (pageNo == null) {
			pagingBean = new PagingBean(getTotalSearchedQuestionCountByWord);
		} else {
			pagingBean = new PagingBean(getTotalSearchedQuestionCountByWord, Integer.parseInt(pageNo));
		}
		request.setAttribute("pagingBean", pagingBean);
		// </paging>
		ArrayList<QuestionVO> list = QuestionBoardDAO.getInstance().searchQuestion(word, pagingBean);
		request.setAttribute("list", list);
		System.err.println(list);
		request.setAttribute("url", "/board/resultSearch.jsp");
		return "template/layout.jsp";
	}

}
