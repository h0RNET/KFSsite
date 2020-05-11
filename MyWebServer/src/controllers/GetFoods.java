package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Goods;
import models.UseModel;

//Сервлет для получения товаров из БД в формате JSON

@WebServlet("/GetFoods")
public class GetFoods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("views/mainpage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int id_type = Integer.parseInt(request.getParameter("id_type")); //получаем из tab.js id типа продукта (еда - 1 или напиток - 2)
		JsonObject jobj = null; //готовим переменную класса Json Object для передачи данных в ajax в формате json 
		if (id_type == 1 || id_type == 2) { 
			try {
				jobj = UseModel.getGoodsByType(id_type); // получаем объект формата Json
			} catch (ClassNotFoundException | SQLException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.setContentType("application/json");  //содержимое ответа будет в формате json 
		response.getWriter().print(jobj); // отправляем содержимое в ajax

	}

}
