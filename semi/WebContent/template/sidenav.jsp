<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
 <div class="col-sm-2 sidenav">
 		<c:choose>	
 		<c:when test="${sessionScope.mvo.status==1 }">
    <p><a href="${pageContext.request.contextPath}/QuestionController.do">문제 관리</a></p>
      <p><a href="${pageContext.request.contextPath}/CouponFormController.do">쿠폰 관리</a></p>
      <p><a href="${pageContext.request.contextPath}/ManageMemberFormController.do">회원 관리</a></p>

</c:when>
    	<c:otherwise>
	   	<p><a href="${pageContext.request.contextPath}/HomeController.do">전체 보기</a></p>
      <p><a href="${pageContext.request.contextPath}/ListController.do?category=se">JavaSE</a></p>
      <p><a href="${pageContext.request.contextPath}/ListController.do?category=jdbc">JavaJDBC</a></p>
      <p><a href="${pageContext.request.contextPath}/ListController.do?category=web">WebProgramming</a></p>
      <br><br><br><br><br><br><br><br><br><br><br><br>
      <div style="text-align: center;">
	<img src="${pageContext.request.contextPath}/img/alien.png" width="220" height="220">
</div>
    	</c:otherwise>
    	</c:choose>
    </div>