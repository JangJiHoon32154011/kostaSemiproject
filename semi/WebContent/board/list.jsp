<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-hover">
	<thead>
		<tr>

			<th>번호</th>
			<th class="title">제목</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach var="qvo" items="${requestScope.list}">
			<tr>
				<td>${qvo.questionNo }</td>
				<td><c:choose>
						<c:when test="${sessionScope.mvo!=null}">
							<a
								href="${pageContext.request.contextPath}/PostDetailController.do?questionNo=${qvo.questionNo }">
								${qvo.title }</a>
						</c:when>
						<c:otherwise>
				${qvo.title }
				</c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
		<tr>
		<c:choose>
			<c:when test="${sessionScope.mvo.status==1 }">
			<td><a
				href="${pageContext.request.contextPath}/AddQuestionFormController.do">문제
					추가하기</a></td>
					</c:when>
					</c:choose>
		</tr>
		<tr>
		
		</tr>
	</tbody>
</table>













