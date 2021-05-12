<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<script type="text/javascript">
	function deletePost() {
		if (confirm("게시글을 삭제하시겠습니까?")) {
			document.deleteForm.submit();
		}
	}
</script>
<div class="container">
<div class="col-lg-2"></div>
<div class="col-lg-6">

<form action="${pageContext.request.contextPath}/ManageMemberDetailController.do">
<h3 style="text-align: center;">회원 상세 내용</h3>
<table class="table">

	<tr>
		<td>ID : </td> <td>${mvo.id } </td>
	</tr>
	<tr>
		<td>NAME : </td> <td>${mvo.name } </td>
	</tr>
	<tr>
		<td>STAMP 갯수 : </td> <td>${mvo.stamp } </td>
	</tr>
	<tr>
		<td>COUPON 갯수 : </td> <td>${mvo.coupon } </td>
	</tr>

</form>
</table>
			<form name="deleteForm"
					action="${pageContext.request.contextPath}/ManageMemberDeleteController.do?id=${mvo.id}" method="post">
			</form>		


<button type="button" class="btn btn-default" onclick="deletePost()">회원 삭제</button>
<button type="button" class="btn btn-default" onclick="updatePost()">알림 전송</button>
</div>
</div>
