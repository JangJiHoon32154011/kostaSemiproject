package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.alien.model.HintVO;
import org.kosta.alien.model.QuestionBoardDAO;

public class HintController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String questionNo=request.getParameter("questionNo");
	HintVO hvo=QuestionBoardDAO.getInstance().getHintByQuestionNo(questionNo);
		System.out.println(hvo);
		if(hvo==null) {
			request.setAttribute("responsebody", questionNo+"에 해당하는 힌트가 없습니다");
		}else {
			request.setAttribute("responsebody",hvo.getContents());
		}
		//Ajax 방식으로 응답하기 위해 AjaxView로 forwarding 한다
		
		return "AjaxView";	
		}

}
