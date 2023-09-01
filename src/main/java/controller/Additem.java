package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDao;
import dto.Fooditem;

@WebServlet("/additem")
@MultipartConfig
public class Additem extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		double price=Double.parseDouble(req.getParameter("price"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
//		double price = Double.parseDouble(req.getParameter("price"));
//		int quantity = Integer.parseInt(req.getParameter("quantity"));
		String type = req.getParameter("type");

		byte[] picture = new byte[req.getPart("pic").getInputStream().available()];
		req.getPart("pic").getInputStream().read(picture);

		Fooditem item = new Fooditem();

		item.setName(name);
		item.setPicture(picture);
		item.setPrice(price);
		item.setQuantity(quantity);
		item.setType(type);
		MyDao m1 = new MyDao();
		m1.Additem(item);
		resp.getWriter().print("<h1 style='color:green'>Item Added Successfully</h1>");
		req.getRequestDispatcher("AdminHome.html").include(req, resp);
		System.out.println("add item");
	}
}