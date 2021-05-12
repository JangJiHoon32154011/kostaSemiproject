<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<script type="text/javascript">
  let xhr;
function LikeAjax(){
	//let mid=document.getElementById("questionNo").value;
	//alert("start ajax");
	xhr=new XMLHttpRequest(); //Ajax 통신을 위한 자바스크립트 객체
	//alert(xhr);
	//XMLHttpRequest의 속성에 callback 함수를 바인딩
	//readystate가 변화될 때 callback 함수가 실행
	//서버가 응답할 때 callback 함수를 실행하기 위한 코드이다
	xhr.onreadystatechange=callback;
	//서버로 요청
	let test=xhr.open("GET","LikeController.do?answerNo=${requestScope.avo.answerNo}");
	
	console.log("1 ",xhr);
	
	xhr.send(null);//post 방식일때 form data 명시
}
function callback(){
	console.log(xhr.readyState);
	console.log("2 ",xhr.status);
	console.log("3 ",xhr.readyState);
	console.log(xhr.responseText);
	//readyState가 4 : 서버의 응답 정보를 받은 상태
	//status 가 200 : 정상 수행
	if(xhr.readyState==4&&xhr.status==200){
		//alert(xhr.responseText);
		//xhr.responseText : 서버의 응답데이터를 저장하는 변수
		document.getElementById("likeView").innerHTML=xhr.responseText;
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
			<td> 좋아요 : <span id="likeView">${requestScope.avo.likeCount }</span></td>

		</tr>		
		<tr>
			<td colspan="5" >
			<pre>${requestScope.avo.answerContent}</pre>
			</td>
		</tr>		
		<button type="button" class="btn btn-default" id="like" onclick="LikeAjax()">좋아요 </button>
	</table>