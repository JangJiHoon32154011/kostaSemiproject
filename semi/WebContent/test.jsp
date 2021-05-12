<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function likeAjax(likeFlag){
		if(likeFlag){
			document.getElementById("likeView").innerHTML="<img src='${pageContext.request.contextPath}/img/heart.png' onclick='likeAjax(false)'>";
			//alert("heart 이미지");
		}else{
			document.getElementById("likeView").innerHTML="<img src='${pageContext.request.contextPath}/img/like.png' onclick='likeAjax(true)'>";
			//alert("like 이미지");
		}
	}
</script>
</head>
<body>
<%-- 현 page 보여줄때 like or heart png 를 제공  --%>
<span id="likeView">
<img src="${pageContext.request.contextPath}/img/heart.png"  onclick="likeAjax(true)">
</span>
</body>
</html>



