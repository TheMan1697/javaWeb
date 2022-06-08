<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Member member = new Member("bibibik","1234","비비빅","bibibik@gmail.com");
	request.setAttribute("mem", member);
	
	//{"id":"bibibik", "pw":"1234","name":"자바맨","email":"bibi@bik.com"}
	Gson gson = new Gson();
	String jsonStr = gson.toJson(member);
	System.out.println(jsonStr);
	Member member2 =gson.fromJson(jsonStr, Member.class);
	System.out.println(member2);
	Map<String,Object> map =gson.fromJson(jsonStr, HashMap.class);
	System.out.println(map);
	
%>
<h2>${mem}</h2>
<h2>${mem.id}</h2>
<h2>${mem.getId()}</h2>
<h2>${mem.pw}</h2>
<h2>${mem.name}</h2>
<h2>${mem.email}</h2>
</body>
</html>