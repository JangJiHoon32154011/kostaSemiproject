<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <form action="${pageContext.request.contextPath}/WriteAnswerController.do?questionNo=${requestScope.vo.questionNo}" method="post" >
   <table class="table" >
    <tr>
    <td>제목 &nbsp;&nbsp;
     ${requestScope.vo.title }
    </td>
    </tr>
    <tr>
    <td>문제번호 &nbsp;&nbsp;
    ${requestScope.vo.questionNo }
    </td>
    </tr>   
    <tr>
     <td>     
     <textarea cols="120" rows="15" name="content" required="required" placeholder="본문내용을 입력하세요"></textarea>
     </td>
    </tr> 
     </table>    
     <div class="btnArea">
     <button type="submit" class="btn" >확인</button>  
     <button type="reset" class="btn" >취소</button>   
    </div>  
  </form>