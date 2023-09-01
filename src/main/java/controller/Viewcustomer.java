package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDao;
import dto.Customer;


@WebServlet("/viewcustomer")
public class Viewcustomer extends HttpServlet
{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 MyDao m1=new MyDao();
	  List<Customer> c1=m1.fetchAllCustomer();
	  if(c1.isEmpty())
	  {
		  resp.getWriter().print("<h1 style='color:red'>No Items Found</h1>");
		  req.getRequestDispatcher("AdminHome.html").include(req, resp);
	  }
	  else {
		  req.setAttribute("list", c1);
		  req.getRequestDispatcher("ViewCustomer.jsp").include(req, resp);
	  }
}
}
