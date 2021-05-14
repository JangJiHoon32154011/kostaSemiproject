package org.kosta.alien.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.MemberDAO;
import org.kosta.alien.model.MemberVO;
import org.kosta.alien.model.PagingBean;

public class ManageMemberFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("mvo") == null) {
			return "redirect:index.jsp";
		}

		int getTotalMemberCount = MemberDAO.getInstance().getTotalMemberCount();
		String pageNo = request.getParameter("pageNo");
		PagingBean pagingBean = null;
		if (pageNo == null) {
			pagingBean = new PagingBean(getTotalMemberCount);
		} else {
			pagingBean = new PagingBean(getTotalMemberCount, Integer.parseInt(pageNo));
		}
		request.setAttribute("pagingBean", pagingBean);

		ArrayList<MemberVO> list = MemberDAO.getInstance().getMemberIdList(pagingBean);
		request.setAttribute("list", list);
		request.setAttribute("url", "/manage/manageMember.jsp");
		return "/template/layout.jsp";
	}

}
