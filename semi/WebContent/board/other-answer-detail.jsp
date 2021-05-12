<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<script type="text/javascript">
  let xhr;
  let like;
function LikeAjax(likeFlag){
	like=likeFlag;
	//let mid=document.getElementById("questionNo").value;
	//alert("start ajax");
	xhr=new XMLHttpRequest(); //Ajax 통신을 위한 자바스크립트 객체
	//alert(xhr);
	//XMLHttpRequest의 속성에 callback 함수를 바인딩
	//readystate가 변화될 때 callback 함수가 실행
	//서버가 응답할 때 callback 함수를 실행하기 위한 코드이다
	xhr.onreadystatechange=callback;
	//서버로 요청
	let test=xhr.open("POST","LikeController.do");
	
	//console.log("1 ",xhr);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("answerNo=${requestScope.avo.answerNo}");//post 방식일때 form data 명시
	if(like){
		document.getElementById("likeView").innerHTML="<img src='${pageContext.request.contextPath}/img/heart.png' width='50' height='50' onclick='likeAjax(false)'>";
		//alert("heart 이미지");
	}else{
		document.getElementById("likeView").innerHTML="<img src='${pageContext.request.contextPath}/img/like.png' width='50' height='50' onclick='likeAjax(true)'>";
		//alert("like 이미지");
	}
	
}


function callback(){
	//console.log(xhr.readyState);
	//console.log("2 ",xhr.status);
	//console.log("3 ",xhr.readyState);
	//console.log(xhr.responseText);
	//readyState가 4 : 서버의 응답 정보를 받은 상태
	//status 가 200 : 정상 수행
	if(xhr.readyState==4&&xhr.status==200){
		//alert(xhr.responseText);
		//xhr.responseText : 서버의 응답데이터를 저장하는 변수
		
		document.getElementById("likeView").innerHTML=xhr.responseText;
		//alert(like+"이미지변경하면 됨");
		
	}
}
</script>

<table class="table">
		<tr >
			<td>글번호 ${requestScope.avo.questionNo }</td>
			<td>아이디: ${requestScope.avo.id} </td>
			<td>등록일: ${requestScope.avo.answerDate }</td>
			
		</tr>
		<tr>
		
			<td> 조회수 : ${requestScope.avo.hits }</td>
			<td> 좋아요 : 		</td>

		</tr>		
		<tr>
			<td colspan="5" >
			<pre>${requestScope.avo.answerContent}</pre>
			</td>
		</tr>		
		
	</table>
		<button type="button" class="btn btn-default" id="like" onclick="LikeAjax(true)">좋아요 </button>
		
		<c:choose>
		<c:when test="${requestScope.likeStatus}">
		
		 
		 <span id="likeView">
		 <img src="${pageContext.request.contextPath}/img/heart.png" width='50' height='50' onclick="likeAjax(false)">${requestScope.avo.likeCount }
		 </span>

		</c:when>
		<c:otherwise>
		
		<span id="likeView">
		<img src="${pageContext.request.contextPath}/img/like.png" width='50' height='50' onclick="likeAjax(true)">${requestScope.avo.likeCount }
		</span>
		</c:otherwise>
		</c:choose> 

