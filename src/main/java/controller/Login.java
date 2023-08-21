package controller;

import java.io.IOException;

import dao.MyDao;
import dto.Customer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Mapping the url
@WebServlet("/login")

public class Login extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //receive values from front end
	String email=req.getParameter("email");
	String password=req.getParameter("pass");
	
	//verify if email exists
	MyDao m=new MyDao();
	if(email.equals("admin@jsp.com")&& password.equals("admin"))
	{
		resp.getWriter().print("<h1 style='color:green'>Login Sucess</h1>");
		//this is logic to send the next page
		req.getRequestDispatcher("AdminHome.html").include(req, resp);
	}
	else {
		
	
	Customer c=m.fetchByEmail(email);
	if(c==null)
	{
		resp.getWriter().print("<h1 style='color:red'>Invalid Email</h1>");
		req.getRequestDispatcher("index.html").include(req, resp);
	}
	else
	{
		if(password.equals(c.getPass()))
		{
			resp.getWriter().print("<h1 style='color:green'>Login sucess</h1>");
			//this is logic to send to next page
			req.getRequestDispatcher("home.html").include(req, resp);
		}
		else {
		  //if response should be both text and html
			//resp.setContentType("text/html");
			resp.getWriter().print("<h1 style='color:red'>Invalid password</h1>");
			req.getRequestDispatcher("index.html").include(req, resp);
		}
	}
}
}
}