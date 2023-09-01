package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDao;
import dto.Fooditem;

@WebServlet("/delete")
public class DeleteItem extends HttpServlet
{
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//getting id from the url
	 int id=Integer.parseInt(req.getParameter("id"));
	 MyDao m1=new MyDao();
	 //finding object because remove method accepts object
	 Fooditem item=m1.find(id);
	 m1.delete(item);
	 resp.getWriter().print("<h1 style='color:green'>Data delete Successfully</h1>");
	 req.getRequestDispatcher("viewmenu").include(req, resp);
	 
}
}
