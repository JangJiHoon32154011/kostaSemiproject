<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 <form action="${pageContext.request.contextPath}/UpdateAnswerController.do" method="post" >
 <input type="hidden" name="ano" value="${vo.answerNo}"></input>	
   <table class="table" >
    <tr>
    <td>문제번호 &nbsp;&nbsp;
     <input type="text" name="qno" value="${vo.questionNo}" required="required">
    </td>
    </tr>   
    <tr>
     <td>     
     <textarea cols="120" rows="15" name="answerContent" required="required" >${vo.answerContent }</textarea>
     </td>
    </tr> 
     </table>    
     <div class="btnArea">
     <button type="submit" class="btn" >수정</button>  
     <button type="reset" class="btn" >취소</button>   
    </div>  
  </form>


