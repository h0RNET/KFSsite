package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Сервлет для завершения сессии (выход из аккаунта) 

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.sendRedirect("MainPage"); //перенаправляем на главную страницу
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(); //получаем объект сессии
		session.removeAttribute("customer"); //удаляем данные о сессии у юзера
		PrintWriter out = response.getWriter();
		out.println(
				"Вы вышли из системы.<br> <h3><b>После выхода из аккаунта все данные о заказах будут стерты!</b></h3> <br>Через 3 секунды вы будете перенаправлены на главную страницу");
		response.setIntHeader("Refresh", 3); //обновляем страницу через 3 секунды, после обновления вызовется метод doGet
	}

}
