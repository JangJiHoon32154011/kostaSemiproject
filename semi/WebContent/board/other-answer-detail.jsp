<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<table class="table">
		<tr >
			<td>글번호 ${requestScope.avo.questionNo }</td>
			<td>아이디: ${requestScope.avo.id} </td>
			<td>등록일: ${requestScope.avo.answerDate }</td>
			
		</tr>
		<tr>
			<td> 조회수 : ${requestScope.avo.hits }</td>
			<td> 좋아요 : ${requestScope.avo.likeCount }</td>
		</tr>		
		<tr>
			<td colspan="5" >
			<pre>${requestScope.avo.answerContent}</pre>
			</td>
		</tr>		
	</table>