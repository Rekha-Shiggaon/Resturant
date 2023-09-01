<%@page import="java.time.LocalDateTime"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>This is HTML </h1>
<%
System.out.println("this is java");
%>

<%
int a=7;
System.out.println(a);
%>

<%! int a=10; %>
<%

System.out.println(this.a);
%>
<%
System.out.println(a);
%>
<h1 style="color:red"><%=LocalDateTime.now() %></h1>

</body>
</html>