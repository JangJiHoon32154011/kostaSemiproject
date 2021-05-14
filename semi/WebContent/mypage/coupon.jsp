<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<img src="${pageContext.request.contextPath}/img/coupon.png" width="250"
	height="250">
<form
	action="${pageContext.request.contextPath}/CouponViewController.do">
	<table class="table">
		<tr>
			<td>내가 받은 스탬프 수 :</td>
			<td>${vo.stamp}</td>
			<td>내가 받은 쿠폰 수 :</td>
			<td>${vo.coupon}</td>
		</tr>
	</table>
</form>

