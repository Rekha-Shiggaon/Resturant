package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDao;
import dto.Customer;
import dto.Fooditem;

@WebServlet("/deletecustomer")
public class DeleteCustomer extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

int id=Integer.parseInt(req.getParameter("id"));
MyDao m1=new MyDao();
Customer c=m1.findCustomer(id);
m1.delete(c);
resp.getWriter().print("<h1 style='color:green'>Data delete Successfully</h1>");
req.getRequestDispatcher("viewcustomer").include(req, resp);
}
}

