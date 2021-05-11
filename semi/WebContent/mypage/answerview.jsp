<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	
<table class="table table-hover">
		<tr>
		<td>
		${requestScope.qvo.title }
		</td>
		</tr>
		<tr>
		<td>
			${requestScope.qvo.contents }
		</td>
		</tr>
</table>
<table class="table table-hover">
	
		<thead>
		<tr>
			<th>문제 번호</th>
			
			<th> 아이디 </th>
			<th > 답변 번호</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="avo" items="${requestScope.list}">
			<tr>
				<td>${avo.questionNo }</td>
				<td>${avo.id }</td>
				<td> ${avo.answerNo }</td>
				
			</tr>
		</c:forEach>
		
		
	</tbody>
</table>
	