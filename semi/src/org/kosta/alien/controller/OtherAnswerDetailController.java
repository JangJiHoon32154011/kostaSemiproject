package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.AnswerDAO;
import org.kosta.alien.model.AnswerVO;
import org.kosta.alien.model.LikeDAO;
import org.kosta.alien.model.LikeVO;
import org.kosta.alien.model.MemberVO;

public class OtherAnswerDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("mvo") == null) {
			return "redirect:index.jsp";
		}

		String id = request.getParameter("id");
		System.out.println("---" + id);

		String ano = request.getParameter("ano");
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		System.out.println("check" + ano + " " + mvo.getId());

		System.out.println(id);
		// 로그인 아이디와 문제 푼 사람이 같다면 no hit++
		if (mvo.getId().equals(id) == false) {
			AnswerDAO.getInstance().updateHit(ano);
		}
		AnswerVO avo = AnswerDAO.getInstance().getOtherDetailAnswer(Integer.parseInt(ano));
		LikeVO lvo = LikeDAO.getInstance().likeStatus(id, ano);
		System.out.println(lvo);
		if (lvo == null) {
			System.out.println("false");
			request.setAttribute("likeStatus", false);
		} else {
			System.out.println("true");
			request.setAttribute("likeStatus", true);
		}

		request.setAttribute("avo", avo);
		request.setAttribute("url", "/board/other-answer-detail.jsp");
		// likestatus 확인하고 상태확인해서 이미지 결정하는 값을 request에다가 할당

		return "/template/layout.jsp";
	}

}
