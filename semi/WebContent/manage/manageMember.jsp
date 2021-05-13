<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="container">
<div class="col-lg-2"></div>
<div class="col-lg-6">

<form action="${pageContext.request.contextPath}/ManageMemberFormController.do">
<h3 style="text-align: center;">회원 목록</h3>
<table class="table table-hover">
<c:forEach items="${requestScope.list}" var="mvo" varStatus="list">
	<tr>
	<c:choose> 
	<c:when test="${mvo.status==0 }">	
		<td>${list.count } </td>
		<td>
			<a href="${pageContext.request.contextPath}/ManageMemberDetailController.do?id=${mvo.id}">${mvo.id }</a>
		</td>
		<td>${mvo.name } </td>
		</c:when>
	</c:choose>
	</tr>
</c:forEach>
</table>
</form>
<%-- 페이징 처리 --%>
<%-- ${requestScope.pagingBean} --%>
<c:set var="pb" value="${requestScope.pagingBean}"></c:set>
<div class="pagingArea" style="text-align: center">
	<ul class="pagination">
	<c:if test="${pb.previousPageGroup}">
	<li><a href="ManageMemberFormController.do?pageNo=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
	</c:if>
		<c:forEach var="page" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
		<c:choose>
			<c:when test="${pb.nowPage==page}">
			<li class="active"><a href="ManageMemberFormController.do?pageNo=${page}">${page}</a></li>
			</c:when>
			<c:otherwise>
			<li><a href="ManageMemberFormController.do?pageNo=${page}">${page}</a></li>
			</c:otherwise>
		</c:choose>		
		</c:forEach>
	<c:if test="${pb.nextPageGroup}">
	<li><a href="ManageMemberFormController.do?pageNo=${pb.endPageOfPageGroup+1}">&raquo;</a></li>
	</c:if>	
	</ul>
</div>

<form action="${pageContext.request.contextPath}/ManageMemberDetailController.do">
<div class="form-group">
<input type="text" class="form-control" name="id"placeholder="회원 ID로 조회" required="required"> 
</div>
<div class="form-group">
<button type="submit"class="btn btn-default" >회원 검색</button>
</div>
</form>

</div>
</div>