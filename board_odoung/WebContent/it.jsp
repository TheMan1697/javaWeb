<%@page import="java.io.InputStreamReader"%><%@page import="java.io.InputStream"%><%@page import="java.io.BufferedReader"%><%@page import="java.net.URL"%><%@ page language="java" contentType="text/xml; charset=UTF-8"    pageEncoding="UTF-8"%>
<%
	URL url = new URL("https://rss.hankyung.com/feed/headline.xml");
	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
	String s= null;
	while((s = br.readLine())!= null){
		out.print(s);
	}
%>