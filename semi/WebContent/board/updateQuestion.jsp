<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <form action="${pageContext.request.contextPath}/UpdateQuestionController.do" method="post" >
 	
   <table class="table" >
    <tr>
    <td>문제번호 &nbsp;&nbsp;
     <input type="text" name="qno" value="${qvo.questionNo}" required="required" readonly="readonly">
    </td>
    </tr>
    <tr>
    <td>
     <p>제목 &nbsp;&nbsp;

   ${qvo.title }</p>
    </td>
    </tr>   
    <tr>
     <td>     
     <textarea cols="120" rows="15" name="questionContent" required="required" >${qvo.contents }</textarea>
     </td>
    </tr> 
     </table>    
     <div class="btnArea">
     <button type="submit" class="btn" >수정</button>  
     <button type="reset" class="btn" >취소</button>   
    </div>  
  </form>


