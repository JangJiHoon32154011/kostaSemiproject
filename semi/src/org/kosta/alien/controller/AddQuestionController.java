package org.kosta.alien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.alien.model.MemberVO;
import org.kosta.alien.model.QuestionBoardDAO;
import org.kosta.alien.model.QuestionVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AddQuestionController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		//String workspacePath="C:\\kosta215\\git\\kostaSemiproject\\semi\\WebContent\\upload";
		String workspacePath=request.getServletContext().getRealPath("upload");
	      System.out.println(workspacePath);
	      int sizeLimit = 1024*1024*10;
	      MultipartRequest multi = new MultipartRequest(request, workspacePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
	      
	      String title=multi.getParameter("title");
	      String category=multi.getParameter("category");
	      String contents=multi.getParameter("contents");
	      MemberVO mvo=(MemberVO)session.getAttribute("mvo");
	      String fileName = multi.getFilesystemName("picture");
	      
	      System.out.println("origin:"+multi.getOriginalFileName("picture"));
	      QuestionVO vo=new QuestionVO();
	      
	      vo.setTitle(title);
	      vo.setCategory(category);
	      vo.setPicture(fileName);
	      vo.setContents(contents);
	      System.out.println("db insert전 vo:"+vo);
	      QuestionBoardDAO.getInstance().AddQuestion(vo);

	      System.out.println("db insert후 vo:"+vo);
		  return "index.jsp";
//	      request.setAttribute("url", "/board/welcome.jsp");      
//	      return "template/layout.jsp";
	}

}
