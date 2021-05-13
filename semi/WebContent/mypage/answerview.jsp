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
				<td>
				<a href="${pageContext.request.contextPath}/OtherAnswerDetailController.do?ano=${avo.answerNo }&id=${avo.id }">
								 ${avo.answerNo }</a></td>
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
	<li><a href="ViewAnswerController.do?qno=${param.qno}&pageNo=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
	</c:if>
		<c:forEach var="page" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
		<c:choose>
			<c:when test="${pb.nowPage==page}">
			<li class="active"><a href="ViewAnswerController.do?qno=${param.qno}&pageNo=${page}">${page}</a></li>
			</c:when>
			<c:otherwise>
			<li><a href="ViewAnswerController.do?qno=${param.qno}&pageNo=${page}">${page}</a></li>
			</c:otherwise>
		</c:choose>		
		</c:forEach>
	<c:if test="${pb.nextPageGroup}">
	<li><a href="ViewAnswerController.do?qno=${param.qno}&pageNo=${pb.endPageOfPageGroup+1}">&raquo;</a></li>
	</c:if>	
	</ul>
</div>
