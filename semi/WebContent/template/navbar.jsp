<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function logout() {
		var f = confirm("로그아웃하시겠습니까?");
		if (f)
			location.href = "${pageContext.request.contextPath}/LogoutController.do";
	}	
</script>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
     
      <a class="navbar-brand" href="${pageContext.request.contextPath}/HomeController.do">ALIENDA</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}/HomeController.do">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/MypageController.do">마이페이지</a></li>
        <c:choose>
        <c:when test="${sessionScope.mvo==null}">
        <li><a href="${pageContext.request.contextPath}/SignUpFormController.do">회원가입</a></li>
        <li><a href="${pageContext.request.contextPath}/FindPasswordFormController.do">비밀번호 찾기</a></li>
		
		<form  class="navbar-form navbar-right" method="post" action="${pageContext.request.contextPath}/LoginController.do">
		<input type="text" class="form-control" name="id" placeholder="아이디" size="12">
		<input type="password" class="form-control" name="password" placeholder="비밀번호" size="12">
		<button type="submit" class="btn btn-default">로그인</button>
		</form>
		
		</c:when>
		<c:otherwise>
		<li><h4>${sessionScope.mvo.name}님 안녕하세요</h4></li>
		<li><button type="submit" class="btn btn-default" onclick="logout()">로그아웃</button><li>
		</c:otherwise>
		</c:choose>
		</ul>
      
      
      <form class="navbar-form navbar-right" action="${pageContext.request.contextPath}/SearchController.do">
			<div class = "container-fluid">
			<div class="form-group">
			<input type="text" name="word" class="form-control" placeholder="문제를 검색하세요.">
			</div>
		<button type="submit" class="btn btn-default">검색</button>
		</div>
		</form>
	
	</div>
    </div>
</nav>