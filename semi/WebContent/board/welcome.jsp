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
				${qvo.title}
				</c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
</table>

<%-- 페이징 처리 --%>
<%-- ${requestScope.pagingBean} --%>
<c:set var="pb" value="${requestScope.pagingBean}"></c:set>
<div class="pagingArea" style="text-align: center">
	<ul class="pagination">
	<c:if test="${pb.previousPageGroup}">
	<li><a href="ListController.do?category=${param.category}&pageNo=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
	</c:if>
		<c:forEach var="page" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
		<c:choose>
			<c:when test="${pb.nowPage==page}">
			<li class="active"><a href="ListController.do?category=${param.category}&pageNo=${page}">${page}</a></li>
			</c:when>
			<c:otherwise>
			<li><a href="ListController.do?category=${param.category}&pageNo=${page}">${page}</a></li>
			</c:otherwise>
		</c:choose>		
		</c:forEach>
	<c:if test="${pb.nextPageGroup}">
	<li><a href="ListController.do?category=${param.category}&pageNo=${pb.endPageOfPageGroup+1}">&raquo;</a></li>
	</c:if>	
	</ul>
</div>