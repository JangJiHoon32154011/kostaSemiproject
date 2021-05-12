<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function checkValue() {
		let form = document.memberInfo;

		if (!form.id.value) {
			alert("아이디를 입력하세요!");
			return false;
		}
		if (!form.name.value) {
			alert("이름을 입력하세요!");
			return false;
		}
		if (!form.email.value) {
			alert("이메일을 입력하세요!");
			return false;
		}
	}
</script>
<body>
비밀번호 찾기
	<form method="post"
		action="${pageContext.request.contextPath}/FindPasswordController.do"
		name="memberInfo" onsubmit="return checkValue()">
		<table class="table">
			<tr>
				<td><input type="text" name="id" placeholder="아이디" size=15
					onkeydown="inputIdCheck()">
			</tr>
			<tr>
				<td><input type="text" name="name" placeholder="이름" size=15></td>
			</tr>
			<tr>
				<td><input type="text" name="email" placeholder="이메일" size=15>
					<select name="email2" onChange="mailCheck()">
						<option>naver.com</option>
						<option>daum.net</option>
						<option>gmail.com</option>
						<option>nate.com</option>
				</select></td>
			</tr>
		</table>
		
		<button type="submit" class="btn btn-default" onclick="result()">비밀번호 찾기</button>
	</form>
</body>
