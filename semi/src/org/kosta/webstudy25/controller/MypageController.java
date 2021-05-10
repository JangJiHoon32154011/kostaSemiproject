package org.kosta.webstudy25.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy25.model.AnswerBoardDAO;
import org.kosta.webstudy25.model.JAnswerDAO;
import org.kosta.webstudy25.model.JAnswerVO;
import org.kosta.webstudy25.model.MemberVO;

public class MypageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		ArrayList<JAnswerVO> list
		=JAnswerDAO.getInstance().getMyAnswerList(mvo.getId());
		request.setAttribute("list", list);
		request.setAttribute("url", "/board/mypage.jsp");		
		return "/template/layout.jsp";
	}

}
