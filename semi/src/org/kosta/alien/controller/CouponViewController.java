package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.MemberDAO;
import org.kosta.alien.model.MemberVO;

public class CouponViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		MemberVO vo=MemberDAO.getInstance().getCouponDetail(mvo.getId());
		request.setAttribute("vo", vo);
		System.out.println(vo);
		request.setAttribute("url", "/mypage/coupon.jsp");
		return "/template/layout_mypage.jsp";
	}
}
