<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-hover">
		<thead>
		<tr>
			<th>아이디</th>
			<th>문제 번호</th>
			<th>문제 작성시간</th>
		
		</tr>
	</thead>
	<tbody>
		<c:forEach var="avo" items="${requestScope.list}">
			<tr>
				<td>${sessionScope.mvo.id }</td>
				<td> <a href="${pageContext.request.contextPath}/MyAnswerDetailController.do?questionNo=${avo.questionNo}">${avo.questionNo }</a></td>
				<td>${avo.answerDate }</td>
			</tr>
		</c:forEach>
		
		
	</tbody>
</table>