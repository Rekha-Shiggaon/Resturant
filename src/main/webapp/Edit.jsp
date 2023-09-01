<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="dto.Fooditem"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
<%Fooditem item=(Fooditem)request.getAttribute("item"); %>
	<form action="Update" method="post" enctype="multipart/form-data">
			id:<input type="text" name="id" value="<%=item.getId()%>"><br><br>
			name:<input type="text" name="name" value="<%=item.getName()%>"><br><br>
			price:<input type="number" name="price" value="<%=item.getPrice()%>"><br><br>
			Food Type:
	 <%if(item.getType().equals("veg")){ %>
	<input type="radio" name="type" value="veg" checked="checked" >Veg<br>
	<input type="radio" name="type" value="non-veg">Non-Veg
	<%}else{ %>
	<input type="radio" name="type" value="veg" >Veg<br>
	<input type="radio" name="type" value="non-veg" checked="checked" >Non-Veg
	<%} %>
	<br>
			
			
			Quantity:<input type="number" name="quantity" value="<%=item.getQuantity()%>"><br>
			Picture:
			<%String base64 = Base64.encodeBase64String(item.getPicture());%>
			 <img height="50px" width="50px" alt="unknown"
						src="data:image/jpeg;base64,<%=base64%>">
			<input type="file" name="pic"><br>
			<button>Update</button>
			<button type="reset">Cancel</button>
		
		</form><br>
			<a href="AdminHome.html"><button>Back</button></a>
</body>
</html>