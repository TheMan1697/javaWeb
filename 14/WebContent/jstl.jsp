<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//request.setAttribute("str", "가나다라");
%>
<c:set var="str" value="가나다라" scope="request"/>
<p>${str.indexOf("나")}</p>
<p>${fn:indexOf("가나다라","가")}</p>
<c:forEach begin="2" end="9" var="i">
	<c:forEach begin="1" end="9" var="j">
	<p>${i}*${j} =${i*j}</p>
	</c:forEach>
</c:forEach>

<%
	if(true){
		
	}
%>
</body>
</html>