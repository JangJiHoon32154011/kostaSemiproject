<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<hr>
<script type="text/javascript">
	function logout(){
		var f=confirm("로그아웃하시겠습니까?");
		if(f)
			location.href="${pageContext.request.contextPath}/LogoutController.do";
	}
</script>
<img src="${pageContext.request.contextPath}/img/alien.png">
<c:choose>
<c:when test="${sessionScope.mvo==null}">
<h3>Welcome KOSTA 215기 면접시스템</h3>
<form method="post" action="${pageContext.request.contextPath}/LoginController.do">
   <div class="form-group">
     <label for="id">아이디</label>
    <input type="text"  class="form-control" name="id"   placeholder="아이디" size="12"> 
    </div>
    <div class="form-group">
     <label for="id">비밀번호</label>
   <input type="password"  class="form-control" name="password"  placeholder="비밀번호" size="12">
    
    </div>
 
     <button type="submit" class="btn btn-default">로그인</button>
</form>
<form method="post"
			action="${pageContext.request.contextPath}/SignUpFormController.do">
			<input type="submit" value="회원가입">
		</form>
</c:when>
<c:otherwise>
<%-- <a href="${pageContext.request.contextPath}/ListController.do">홈</a>&nbsp;&nbsp;--%>
<%-- <a href="${pageContext.request.contextPath}/WritePostFormController.do">글쓰기</a>&nbsp;&nbsp;--%> 
<%-- <a href="${pageContext.request.contextPath}/MypageController.do">마이페이지</a>&nbsp;&nbsp;--%>
 <h3>${sessionScope.mvo.name}님 안녕하세요 </h3>  
 
 <button type="submit" class="btn btn-default" onclick="logout()">로그아웃</button>
</c:otherwise>

</c:choose>
<div style="text-align:center;">

</div>