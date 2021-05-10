<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
 <div class="col-sm-2 sidenav">
 		<c:choose>	
 		<c:when test="${sessionScope.mvo.status==1 }">
    <p><a href="${pageContext.request.contextPath}/QuestionController.do">문제 관리</a></p>
</c:when>
    	<c:otherwise>
      <p><a href="${pageContext.request.contextPath}/ListController.do?category=se">JavaSE</a></p>
      <p><a href="${pageContext.request.contextPath}/ListController.do?category=jdbc">JavaJDBC</a></p>
      <p><a href="${pageContext.request.contextPath}/ListController.do?category=web">WebProgramming</a></p>
    	</c:otherwise>
    	</c:choose>
    </div>