<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function solvedQuestionAlert(){
		alert("푼 문제에 들어왔습니다");
		location.href="index.jsp";
	}
</script>
<!-- 만약 푼 문제면 alert(00번은 이미 푼 문제입니다) -> 지금 문제의 내 답안 보기 gogo -->
	<table class="table">
		<tr >
			<td>글번호 ${requestScope.qvo.questionNo }</td>
			<td>제목: ${requestScope.qvo.title} </td>
			
		</tr>		
		<tr>
			<td colspan="5" >
			<pre>${requestScope.qvo.contents}</pre>
			</td>
		</tr>		
	</table>
<c:choose>
<c:when test="${sessionScope.mvo.status==1 }">
<a href="${pageContext.request.contextPath}/UpdateQuestionFormController.do?questionNo=${requestScope.qvo.questionNo}">문제수정하기</a>
<br>
<a href="${pageContext.request.contextPath}/DeleteQuestionController.do?questionNo=${requestScope.qvo.questionNo}">문제 삭제하기</a>
	
	</c:when>
	<c:otherwise>
	
<a href="${pageContext.request.contextPath}/WriteAnswerFormController.do?questionNo=${requestScope.qvo.questionNo}">문제풀기</a>
	</c:otherwise>
</c:choose>	
	
	
	
	
	