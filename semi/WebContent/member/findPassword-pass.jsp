<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	alert("비밀번호는[<%=request.getAttribute("password")%>] 입니다.");
	location.href = "${pageContext.request.contextPath}/index.jsp";
</script>















