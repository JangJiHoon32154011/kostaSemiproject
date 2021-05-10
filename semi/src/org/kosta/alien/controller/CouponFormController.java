package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CouponFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null	){
			return "redirect:index.jsp";
		}
		request.setAttribute("url", "/manage/giveCoupon.jsp");
		return "/template/layout.jsp";
	}

}
