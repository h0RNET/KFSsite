package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.UseModel;

//Сервлет для перенаправления на страницу регистрации, и получения данных с этой страницы, и создания нового пользователя

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("views/registration.jsp").forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String login = request.getParameter("login"); //получаем параметр login с registration jsp
		String password = request.getParameter("password"); //получаем параметр password с registration jsp
		String lastName = request.getParameter("lastname"); //получаем параметр lastname с registration jsp
		String firstName = request.getParameter("firstname"); //получаем параметр firstname с registration jsp
		try {
			UseModel.setUser(login, firstName, lastName, password); //добавляем пользователя в БД
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("MainPage"); //перенаправляем на главную страницу
	}

}
