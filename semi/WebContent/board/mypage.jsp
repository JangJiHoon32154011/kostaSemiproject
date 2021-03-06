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
				<td><a
					href="${pageContext.request.contextPath}/MyAnswerDetailController.do?questionNo=${avo.questionNo}">${avo.questionNo }</a></td>
				<td>${avo.answerDate }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>



<%-- 페이징 처리 --%>
<%-- ${requestScope.pagingBean} --%>
<c:set var="pb" value="${requestScope.pagingBean}"></c:set>
<div class="pagingArea" style="text-align: center">
	<ul class="pagination">
		<c:if test="${pb.previousPageGroup}">
			<li><a
				href="MypageController.do?id=${param.id}&pageNo=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
		</c:if>
		<c:forEach var="page" begin="${pb.startPageOfPageGroup}"
			end="${pb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${pb.nowPage==page}">
					<li class="active"><a
						href="MypageController.do?id=${param.id}&pageNo=${page}">${page}</a></li>
				</c:when>
				<c:otherwise>
					<li><a
						href="MypageController.do?category=${param.category}&pageNo=${page}">${page}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pb.nextPageGroup}">
			<li><a
				href="MypageController.do?id=${param.id}&pageNo=${pb.endPageOfPageGroup+1}">&raquo;</a></li>
		</c:if>
	</ul>
</div>