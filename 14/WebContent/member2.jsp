<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="member" class="domain.Member" scope="request"/>
<jsp:setProperty property="id" name="member" value="bibibik"/>
<jsp:setProperty property="pw" name="member" value="1234"/>
<jsp:setProperty property="name" name="member" value="비비빅"/>

<h2>${member.id}</h2>
<h2><%=member.getId()%></h2>
<h2><jsp:getProperty property="id" name="memeber"/></h2>
<h2><c:out value="${member.id}" /></h2>
</body>
</html>