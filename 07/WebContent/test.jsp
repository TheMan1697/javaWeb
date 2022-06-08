<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>test.jsp</h1>
<h2>${param.val}</h2>
<h2>한글</h2>
<h2><%=request.getParameter("val")%></h2>
<%--@ include file="test2.jsp" --%>
<iframe src="test2.jsp?val=20"></iframe>
</body>
</html>