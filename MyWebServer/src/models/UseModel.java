package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

public class UseModel {

	/**
	 * Метод для получения списка товаров указанного типа "drink" либо "food"
	 * 
	 * @param type Тип списка товаров который нужно получить food либо drink
	 * @return Объект типа Json
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static JsonObject getGoodsByType(int id_category) throws ClassNotFoundException, SQLException {
		ResultSet rs = ORM_SQL.select(
				"SELECT id_good,title,id_category,price,image FROM goods where id_category=" + id_category);

		return CreateJSON.getJSON(rs);
	}

	/**
	 * Метод для добавления пользователя в БД
	 * 
	 * @param login
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static boolean setUser(String login, String firstName, String lastName, String password) throws Exception {

		Hashtable<String, String> user = new Hashtable<String, String>();
		user.put("FirstName", firstName);
		user.put("LastName", lastName);
		user.put("login", login);
		user.put("password", password);

		int result = ORM_SQL.insertTable("customers", user);

		return (result == 1 ? true : false);
	}

	/**
	 * Метод для получения информации о посетителе из БД
	 * 
	 * @param
	 * @return объект класса Customers
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public static Customers getCustomer(String login) throws ClassNotFoundException, SQLException {

		String query = "SELECT id_customer,LastName,FirstName,password FROM customers WHERE login ='" + login + "'";
		ResultSet rs = ORM_SQL.select(query);
		if (rs.next()) {
			String id_customer = rs.getString("id_customer");
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			String password = rs.getString("password");
			return new Customers(id_customer, login, firstName, lastName, password);
		}
		return null;
	}

	/**
	 * Добавление товара в корзину. Каждая корзина имеет своего покупателя, <br>
	 * Покупатель может повторяться, потому что может купить много товаров
	 * 
	 * @param id_customer
	 * @param id_good
	 * @throws Exception
	 */
	public static void addToBasket(String id_customer, String id_good) throws Exception {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("id_customer", id_customer);
		ht.put("id_good", id_good);
		ORM_SQL.insertTable("basket", ht);
	}

	/**
	 * Метод для получения списка товаров, которые выбрал конкретный покупатель
	 * 
	 * @param id_customer
	 * @return <b>ArrayList<Goods></b> коллекция объектов Goods
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<Goods> getGood(String id_customer) throws ClassNotFoundException, SQLException {
		ResultSet rs = ORM_SQL.select(
				"SELECT title, price, image FROM goods INNER JOIN basket ON basket.id_good=goods.id_good WHERE id_customer="
						+ id_customer);
		ArrayList<Goods> listGoods = new ArrayList<Goods>();
		String title = "";
		String price = "";
		String image = "";
		while (rs.next()) {
			title = rs.getString("title");
			price = rs.getString("price");
			image = rs.getString("image");
			listGoods.add(new Goods(null, title, null, price, image));
		}
		return listGoods;
	}

	/**
	 * Метод для получения количества товаров, добавленных в корзину конкретным
	 * покупателем
	 * 
	 * @param id_customer
	 * @return <b>int</b> количество товаров
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public static int getCountGoods(String id_customer) throws ClassNotFoundException, SQLException {
		ResultSet rs = ORM_SQL.select(
				"SELECT title, price, image FROM goods INNER JOIN basket ON basket.id_good=goods.id_good WHERE id_customer="
						+ id_customer);
		int count = 0;
		while (rs.next()) {
			count++;
		}

		return count;
	}
}
