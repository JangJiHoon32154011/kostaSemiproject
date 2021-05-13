package org.kosta.alien.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.AnswerDAO;
import org.kosta.alien.model.AnswerVO;
import org.kosta.alien.model.MemberVO;
import org.kosta.alien.model.PagingBean;
import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;

public class ViewAnswerController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그인 상태 확인
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		String qno=request.getParameter("qno");
		// QNo에 따른 총 답변 수
		int getTotalAnswerByQNo=AnswerDAO.getInstance().getTotalAnswerByQNo(qno);
		String pageNo = request.getParameter("pageNo");
		PagingBean pagingBean = null;
		
		if (pageNo == null) {
			pagingBean = new PagingBean(getTotalAnswerByQNo);
		} else {
			pagingBean = new PagingBean(getTotalAnswerByQNo, Integer.parseInt(pageNo));
		}

		// Qno에 따른 답변 리스트 출력(
		QuestionVO qvo=QuestionBoardDAO.getInstance().getPostingByNo(qno);
		request.setAttribute("qvo", qvo);
		System.out.println(qvo);
		
		request.setAttribute("pagingBean", pagingBean);
		ArrayList<AnswerVO> list = AnswerDAO.getInstance().getAllAnswerListByQNO(qno,pagingBean);
		request.setAttribute("list", list);
		
		request.setAttribute("url", "/mypage/answerview.jsp");		
		return "/template/layout.jsp";
	}

}
