<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>내장객체</h1>
	<!--request 중요  -->
	<h3><%=request %></h3>
	
	<h3><%=response %></h3>
	<h3><%=out %></h3>
	<h3><%=session %></h3>
	<h3><%=application %></h3>
	<h3><%=pageContext %></h3>
	<h3><%=page %></h3>
	<h3><%=page == this%></h3>
	<h3><%=config %></h3>
	<h1>내장객체 중 영역 객체</h1>
	<h3>page</h3>
	<h3>request</h3>
	<h3>session</h3>
	<h3>application</h3>
	<%-- <%
		out.println(request);
		out.println(response);
		out.println(out);
		out.println(session);
		out.println(application);
		out.println(pageContext);
		out.println(page);
		out.println(config);
	%> --%>
</body>
</html>