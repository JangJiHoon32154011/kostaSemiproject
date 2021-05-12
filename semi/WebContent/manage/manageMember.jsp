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