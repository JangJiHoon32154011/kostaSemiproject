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
<label for="id">ID:</label>
<input type="text" class="form-control" name="id" placeholder="id" required="required"> <br>
<label for="id">Stamp:</label>
<input type="number" class="form-control" name="num" placeholder="num" required="required"> <br><br>
<button type="submit"class="btn btn-default">쿠폰 주기</button>
</div>
</form>
</body>
</html>