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
        <li><a href="#">About</a></li>
        <li><a href="${pageContext.request.contextPath}/MypageController.do">마이페이지</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      
    </div>
  </div>
</nav>