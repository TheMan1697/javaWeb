<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
.board-table-inner {border: 1px solid black; width: 1200px; 
             margin: 0 auto; font-size: 13px; font-family: Georgia, 'Times New Roman', Times, serif; table-layout: fixed; word-break: keep-all;}
            th, td{padding: 18px;}
             th{border-top: 3px solid;border-bottom: 3px solid; vertical-align: top;}
        td{border-bottom: 1px solid;}
</style>
</head>
<body>
	<table class="board-table-inner">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>닉네임</th>
			<th>이메일</th>
			<th>가입일</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${members}" var="member">
		<tr>
			<td>${member.id}</td>
			<td>${member.pw}</td>
			<td>${member.name}</td>
			<td>${member.nick}</td>
			<td>${member.email}</td>
			<td>${member.joinDate}</td>
			<td><a href="remove?id=${member.id}">삭제</a>
		</tr>
		</c:forEach>
	</table>
</body>
</html>