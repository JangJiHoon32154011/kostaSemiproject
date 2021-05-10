<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function deletePost() {
		if (confirm("게시글을 삭제하시겠습니까?")) {
			document.deleteForm.submit();
		}
	}
	function updatePost() {
		if (confirm("게시글을 수정하시겠습니까?")) {
			document.updateForm.submit();
		}
	}
	
</script>
	<table class="table">
		<tr >
			<td>아이디 ${requestScope.javo.id }</td>
			<td>문제번호: ${requestScope.javo.questionNo} </td>
			<td>작성시간: ${requestScope.javo.answerDate }</td>
		</tr>		
		<tr>
			<td colspan="5" >
			<pre>${requestScope.javo.answerContent}</pre>
			</td>
		</tr>		
		<tr>
		<td colspan="5" class="btnArea">
				<form name="deleteForm"
					action="${pageContext.request.contextPath}/DeleteAnswerController.do" method="post">
					<input 	type="hidden" name="ano" value="${requestScope.javo.answerNo}">
				</form>				
				<form name="updateForm"
					action="${pageContext.request.contextPath}/UpdateAnswerFormController.do" method="post">
					<input 	type="hidden" name="ano" value="${requestScope.javo.answerNo}">
				</form>
				<button type="button" class="btn" onclick="deletePost()">삭제</button>
				<button type="button" class="btn" onclick="updatePost()">수정</button>
				<hr>
				<a href="${pageContext.request.contextPath}/ViewAnswerController.do?qno=${requestScope.javo.questionNo}">다른 사람 답안 보러가기</a>
			</td>
		</tr>
	</table>

	
	
