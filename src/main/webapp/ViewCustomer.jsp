<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="java.util.List"%>
<%@page import="dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	List<Customer> c1 = (List<Customer>) request.getAttribute("list");
	%>

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Picture</th>
			<th>Password</th>
			<th>Email</th>
			<th>DOB</th>
			<th>Gender</th>
			<th>Mobile</th>
			<th>Country</th>
		</tr>
		<%for(Customer c:c1) {%>
		<tr>
			<th><%=c.getId()%></th>
			<th><%=c.getName()%></th>
			<th>
			<%String base64 = Base64.encodeBase64String(c.getPicture());%>
			 <img height="100px" width="100px" alt="unknown"
						src="data:image/jpeg;base64,<%=base64%>">
						</th>
			
		   <th><%=c.getPass() %></th>
		   <th><%=c.getEmail() %></th>
		     <th><%=c.getDob() %></th>
		       <th><%=c.getGender() %></th>
		         <th><%=c.getMobile() %></th>
		           <th><%=c.getCountry()%></th>
		             
		          	<th><a href="deletecustomer?id=<%=c.getId()%>"><button>Delete</button></th></a>
		</tr>
		<%} %>
	</table>
	<br>
	<a href="AdminHome.html"><button>Back</button></a>

</body>
</html>