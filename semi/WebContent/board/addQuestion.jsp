<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <form action="${pageContext.request.contextPath}/AddQuestionController.do" method="post" >
   <table class="table" >
    <tr>
    <td>
    <textarea cols="100" rows="1" name="title" required="required" placeholder="제목"></textarea>
    </td>
    </tr>
    <tr>
    <td>
    <select name="category">
    <option value="se">Java SE</option>
    <option value="jdbc">Java JDBC</option>
    <option value="web">Java Web programming</option>
</select>
    </td>
    </tr>   
    <tr>
     <td>     
     <textarea cols="120" rows="15" name="contents" required="required" placeholder="본문내용을 입력하세요"></textarea>
     </td>
    </tr> 
     </table>    
     <div class="btnArea">
     <button type="submit" class="btn" >확인</button>  
     <button type="reset" class="btn" >취소</button>   
    </div>  
  </form>