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
<form action="${pageContext.request.contextPath}/CouponController.do">
<div class="form-group">
<input type="text" name="id" placeholder="id" required="required">
<input type="number" name="num" placeholder="num" required="required">
<button type="submit"class="btn btn-default">쿠폰 주기</button>
</div>
</form>
</body>
</html>