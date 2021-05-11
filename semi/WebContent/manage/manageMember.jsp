<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/ManageMemberFormController.do">
<div class="form-group">
<label for="id">ID:</label>
<input type="text" class="form-control" name="id" placeholder="id" required="required"> <br>

<button type="submit"class="btn btn-default">회원 삭제</button>
</div>
</form>
</body>
</html>