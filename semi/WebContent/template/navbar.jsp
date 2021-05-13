<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/HomeController.do">ALIEN</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}/HomeController.do">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/MypageController.do">마이페이지</a></li>
      </ul>
      <form class="navbar-form navbar-right" action="${pageContext.request.contextPath}/SearchController.do">
			<div class = "container-fluid">
			<div class="form-group">
			<input type="text" name="word" class="form-control" placeholder="문제를 검색하세요.">
			</div>
		<button type="submit" class="btn btn-default">검색</button>
		</form>
	</div>
    </div>
  </div>
</nav>