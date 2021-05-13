<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>회원가입 수정</h3>
<script type="text/javascript">
	function checkValue() {
		var form = document.memberInfo;

		if (!form.password.value) {
			alert("비밀번호를 입력하세요!");
			return false;
		}

		if (form.password.value != form.passwordcheck.value) {
			alert("비밀번호를 다시 확인해 주세요!");
			return false;
		}
		
		if(!form.name.value) {
			alert("이름을 입력하세요!");
			return false;
		}
		
		if(!form.email.value) {
			alert("이메일을 입력하세요!");
			return false;
		}
	}

</script>
<body>
	<form method="post"
		action="${pageContext.request.contextPath}/UpdateMemberController.do"
		name="memberInfo" onsubmit="return checkValue()">
		<table class="table">
			<tr>
				<td><input type="text" name="id" size=15 value="${mvo.id}"
					required="required" readonly="readonly"></td>
			</tr>
			<tr>
				<td><input type="password" name="password" placeholder="비밀번호"
					size=20></td>
			</tr>
			<tr>
				<td><input type="password" name="passwordcheck"
					placeholder="비밀번호 확인" size=20></td>
			</tr>
			<tr>
				<td><input type="text" name="name" placeholder="이름" size=15></td>
			</tr>
			<tr>
				<td><input type="text" name="email" placeholder="이메일" size=15>
			</tr>
		</table>
		<br> <button type="submit" class="btn btn-default">수정하기</button>
	</form>
</body>
</html>