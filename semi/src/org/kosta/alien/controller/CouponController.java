package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.MemberDAO;
import org.kosta.alien.model.MemberVO;

public class CouponController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		MemberVO mvo=(MemberVO) session.getAttribute("mvo");
		String id=request.getParameter("id");
		int no=Integer.parseInt(request.getParameter("num"));
		MemberDAO.getInstance().updateStamp(id, no);
		int stampNo=MemberDAO.getInstance().checkStamp(id);
		MemberDAO.getInstance().updateCoupon(id,stampNo);
		return "redirect:index.jsp";
	}

}
