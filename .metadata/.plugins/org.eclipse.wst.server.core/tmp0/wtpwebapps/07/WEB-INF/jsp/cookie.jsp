<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
for(Cookie cookie : cookies){
	out.println(cookie.getName()+"<br>");
	out.println(URLDecoder.decode(cookie.getValue(),"utf-8")+"<br>");
}
%>
</body>
</html>