package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Customers;
import models.Goods;
import models.UseModel;

//Сервлет для вывода товаров в корзине пользователя

@WebServlet("/ShowBasket")
public class ShowBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Customers customer = (Customers) session.getAttribute("customer");
		if (customer != null) {
			ArrayList<Goods> listGoods = new ArrayList<Goods>();
			listGoods.clear();
			try {
				listGoods = UseModel.getGood(customer.getId_customer()); //получаем коллекцию объектов класса Goods на вход даем id юзера из сессии
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("goods", listGoods); //готовим объект listGoods для передачи его в showbasket.jsp
			request.getRequestDispatcher("views/showbasket.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("views/mainpage.jsp").forward(request, response); //если посетитель не авторизован перекидываем его на главную страницу
		}
		
	}
}
