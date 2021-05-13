package org.kosta.alien.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.alien.model.PagingBean;
import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;
/***
 * 문제를 페이징 처리해서 보여줍니다.
 * @author broth
 *
 */
public class ListController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String category = request.getParameter("category");
		// category 별 총 문제 수
		int totalQuestionCount = QuestionBoardDAO.getInstance().getTotalQuestionCountByCategory(category);
		String pageNo = request.getParameter("pageNo");
		PagingBean pagingBean = null;
		if (pageNo == null) {
			pagingBean = new PagingBean(totalQuestionCount);
		} else {
			pagingBean = new PagingBean(totalQuestionCount, Integer.parseInt(pageNo));
		}
		// list.jsp 에서 페이징 처리를 위해 pagingBean을 request 영역에 공유한다
		request.setAttribute("pagingBean", pagingBean);
		ArrayList<QuestionVO> list = QuestionBoardDAO.getInstance().getQuestionList(category, pagingBean);
		request.setAttribute("list", list);
		request.setAttribute("url", "/board/list.jsp");

		return "/template/layout.jsp";
	}
}
