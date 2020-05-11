package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Customers;
import models.UseModel;

@WebServlet("/AddToBasket")
public class AddToBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(); //получаем объект сессии
		Customers customer = (Customers) session.getAttribute("customer"); //достаем у посетителя объект класса Customers под именем customer
		if(customer != null && request.getParameter("id_good")!=null) { //если объект customer есть и параметр id_good, переданный через ajax не null
			try {
				UseModel.addToBasket(customer.getId_customer(), request.getParameter("id_good")); // Добавляем товар в корзину  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().print("Товар добавлен в корзину"); // отправляем ответ в ajax 
		}
		else {
			response.getWriter().print("Вы должны зарегистрироваться прежде чем добавлять товары в корзину"); //отправляем ответ в ajax
		}
	}
}
