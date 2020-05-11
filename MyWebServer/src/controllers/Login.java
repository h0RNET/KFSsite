package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import models.Customers;
import models.UseModel;

//Данный сервлет обрабатывает окно авторизации
// Зашли на сайт первый раз -> авторизации нет
// Чтобы зарегистрироваться, нужно нажать "Зарегистрироваться"
// Чтобы войти в личный кабинет (ЛК) необходимо ввести логин и пароль
// Логин и пароль передаются через POST запрос
// В случае удачного ввода логина и пароля авторизуемся

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Customers customer;
	private HttpSession session;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
		response.sendRedirect("MainPage");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String login = request.getParameter("login"); //получаем параметр login с userinfo.jsp
		String password = request.getParameter("password");//получаем параметр password с userinfo.jsp
		session = request.getSession(); //получаем объект сессии

		try {
			customer = UseModel.getCustomer(login); //получаем нашего юзера из БД по логину
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!(customer == null)) { //если юзер получен из БД
			if(customer.getLogin().equals(login) && customer.getPassword().equals(password)) { //если логин и пароль введены правильно, то создаем сессию, т.е. авторизуем пользователя
				session.setAttribute("customer", customer); //сохраняем юзера в сессии под именем customer
				//customer = (Customers) session.getAttribute("customer"); 
				response.sendRedirect("MainPage");
			}
		}
	}

}
