package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.AnswerDAO;
import org.kosta.alien.model.MemberVO;
import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;

public class WriteAnswerFormController implements Controller {

	/***
	 * 답안 작성을 누를때 작동합니다
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		// 로그인 안 되어있을 때 처리
		if (session == null || session.getAttribute("mvo") == null) {
			return "redirect:index.jsp";
		}
		// 문제 번호
		String qno = request.getParameter("questionNo");
		// NO로 questionVO를 받아온다
		QuestionVO vo = QuestionBoardDAO.getInstance().getPostingByNo(qno);
		// vo를 설정
		request.setAttribute("vo", vo);
		// 로그인 된 memberVO 받기(session)
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");

		int flag = AnswerDAO.getInstance().getUpdateCheck(mvo.getId(), Integer.parseInt(qno));
		if (flag > 0) {// 푼 문제
			
			request.setAttribute("question_NO", qno);

			System.out.println("푼 문제에 들어왔습니다");
			request.setAttribute("url", "/question-fail.jsp");
		} else {// 안 푼 문제
			request.setAttribute("url", "/board/writeAnswer.jsp");
			System.out.println("안 푼 문제에 들어왔습니다");
		}

		return "/template/layout.jsp";
	}

}
