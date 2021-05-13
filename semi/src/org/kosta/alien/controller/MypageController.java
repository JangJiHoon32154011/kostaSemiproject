package org.kosta.alien.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.AnswerDAO;
import org.kosta.alien.model.AnswerVO;
import org.kosta.alien.model.MemberVO;
import org.kosta.alien.model.PagingBean;

public class MypageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("mvo") == null) {
			return "redirect:index.jsp";
		}
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		int totalAnswerCountById = AnswerDAO.getInstance().getTotalAnswerById(mvo.getId());
		String pageNo = request.getParameter("pageNo");
		PagingBean pagingBean = null;
		if (pageNo == null) {
			pagingBean = new PagingBean(totalAnswerCountById);
		} else {
			pagingBean = new PagingBean(totalAnswerCountById, Integer.parseInt(pageNo));
		}
		request.setAttribute("pagingBean", pagingBean);

		ArrayList<AnswerVO> list = AnswerDAO.getInstance().getMyAnswerList(mvo.getId(),pagingBean);

		request.setAttribute("list", list);
		request.setAttribute("url", "/board/mypage.jsp");
		return "/template/layout.jsp";
	}

}
>>>>>>> branch 'main' of https://github.com/JangJiHoon32154011/kostaSemiproject.git
