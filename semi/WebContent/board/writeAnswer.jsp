<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <script type="text/javascript">
  let xhr;
function startAjax(){
	//let mid=document.getElementById("questionNo").value;
	//alert("start ajax");
	xhr=new XMLHttpRequest(); //Ajax 통신을 위한 자바스크립트 객체
	//alert(xhr);
	//XMLHttpRequest의 속성에 callback 함수를 바인딩
	//readystate가 변화될 때 callback 함수가 실행
	//서버가 응답할 때 callback 함수를 실행하기 위한 코드이다
	xhr.onreadystatechange=callback;
	//서버로 요청
	let test=xhr.open("GET","HintController.do?questionNo=${requestScope.vo.questionNo}");
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
		document.getElementById("resultView").innerHTML=xhr.responseText;
	}
}

</script>
  <form action="${pageContext.request.contextPath}/WriteAnswerController.do?questionNo=${requestScope.vo.questionNo}" method="post" >
   <table class="table" >
    <tr>
    <td>제목 &nbsp;&nbsp;
     ${requestScope.vo.title }
    </td>
    </tr>
    <tr>
    <td>문제번호 &nbsp;&nbsp;
    ${requestScope.vo.questionNo }
    </td>
    </tr>   
    <tr>
     <td>     
     <textarea cols="120" rows="15" name="content" required="required" placeholder="본문내용을 입력하세요"></textarea>
     </td>
    </tr> 
     </table>    
     <div class="btnArea">
     <input type="button" value="힌트보기"  id="hint " onclick="startAjax()"><br><br>
     <h3><span id="resultView"></span></h3>
     <br><button type="submit" class="btn" >확인</button>  
     <button type="reset" class="btn" >취소</button>   
    </div>  
  </form>