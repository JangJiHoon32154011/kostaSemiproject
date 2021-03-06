package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.AnswerDAO;
import org.kosta.alien.model.LikeDAO;
import org.kosta.alien.model.LikeVO;
import org.kosta.alien.model.MemberVO;

public class LikeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		
		String answerNo=request.getParameter("answerNo");
		int ano=Integer.parseInt(answerNo);
		String id = AnswerDAO.getInstance().findIdByAnswerNo(ano);

		
		LikeVO lvo=LikeDAO.getInstance().likeStatus(id, answerNo);
		System.out.println("check like: "+ lvo);
		if(lvo==null) {
			LikeDAO.getInstance().likeInsert(id, Integer.parseInt(answerNo));
			LikeDAO.getInstance().addLike(id, answerNo);
			
			int count=LikeDAO.getInstance().checkLikeCount(Integer.parseInt(answerNo));
			request.setAttribute("responsebody", count);
			
		}else {
			LikeDAO.getInstance().subLike(id, answerNo);
			LikeDAO.getInstance().likeDelete(id, Integer.parseInt(answerNo));
			int count=LikeDAO.getInstance().checkLikeCount(Integer.parseInt(answerNo));
			request.setAttribute("responsebody", count);
			
		}
		return "AjaxView";	
	}

}
