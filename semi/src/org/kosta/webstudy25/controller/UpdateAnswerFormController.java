package org.kosta.webstudy25.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy25.model.JAnswerDAO;
import org.kosta.webstudy25.model.JAnswerVO;

public class UpdateAnswerFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null||
				request.getMethod().equals("POST")==false){
			return "redirect:index.jsp";
		}
		JAnswerVO vo=JAnswerDAO.getInstance().getAnswerByAnswerNo(Integer.parseInt(request.getParameter("ano")));
		request.setAttribute("vo", vo);
		request.setAttribute("url", "/board/update.jsp");
		return "/template/layout.jsp";
	}

}
