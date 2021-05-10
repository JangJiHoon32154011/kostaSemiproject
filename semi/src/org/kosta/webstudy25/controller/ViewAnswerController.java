package org.kosta.webstudy25.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy25.model.JAnswerDAO;
import org.kosta.webstudy25.model.JAnswerVO;
import org.kosta.webstudy25.model.MemberVO;

public class ViewAnswerController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		int qno=Integer.parseInt(request.getParameter("qno"));
		ArrayList<JAnswerVO> list
		=JAnswerDAO.getInstance().getAllAnswerList(qno);
		request.setAttribute("list", list);
		request.setAttribute("url", "/mypage/answerview.jsp");		
		return "/template/layout.jsp";
	}

}
