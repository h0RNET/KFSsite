package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TimeZone;
import java.util.concurrent.Executors;

//С помощью данного класса происходит подключение к БД

public class ORM_SQL {

	private static PreparedStatement stmt;
	private static ResultSet rs;
	private static Connection connect;

	private static Connection getConnect() throws ClassNotFoundException, SQLException {

			String url = "jdbc:mysql://localhost/kfs?serverTimezone=" + TimeZone.getDefault().getID();
			Class.forName("com.mysql.cj.jdbc.Driver"); // подключаем драйвер
			connect = DriverManager.getConnection(url, "root", ""); // получаем соединение

		return connect;
	}

	/**
	 * Метод для получения количества записей на основе запроса SQL: SELECT имя
	 * столбца FROM имя таблицы
	 * 
	 * @param SQL
	 * @return <b>int</b> количество записей в столбце
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static int countStrQuery(String SQL) throws SQLException, ClassNotFoundException {

		int count = 0; // счетчик записей
		stmt = connect.prepareStatement(SQL);
		rs = stmt.executeQuery(SQL);// получили кол-во записей после select
		while (rs.next()) {
			count++;
		}
		return count;
	}

	/**
	 * Метод для получения количества полей в таблице
	 * 
	 * @param <b>table</b> имя таблицы
	 * @return <b>int</b> количество полей в таблице
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public static int countFieldsQuery(String table) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM " + table + " limit 1"; // limit 1 - берем только 1 строку, чтоб не загружать
															// всю
															// таблицу
		stmt = getConnect().prepareStatement(table);
		rs = stmt.executeQuery(sql);
		return rs.getMetaData().getColumnCount(); // сначала получаем метаданные, потом из них выдергиваем
													// количество столбцов
	}

	/**
	 * Метод для вызова любого select запроса SQL
	 * 
	 * @param SQL
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public static ResultSet select(String SQL) throws SQLException, ClassNotFoundException {

		stmt = getConnect().prepareStatement(SQL);
		rs = stmt.executeQuery(SQL);
		return rs;
	}

	/**
	 * Метод для добавления строки в любую таблицу.
	 * 
	 * @param table_name - Имя таблицы
	 * @param values     - <b>Ключ</b> и <b>Значение</b>, передаваемые из
	 *                   HashTable<String, String>.<br>
	 *                   <t><b>Ключ</b>- поле таблицы<br>
	 *                   <b>Значение</b> - значение поля
	 * @return <b>int</b> количество измененных записей
	 * @throws Exception
	 */

	public static int insertTable(String table_name, Hashtable<String, String> values) throws Exception {

		String query = "INSERT INTO " + table_name;
		String columns = "";
		String value = "";
		Enumeration<String> e = values.keys(); // получаем перечисление ключей из hashtable

		while (e.hasMoreElements()) {
			String element = e.nextElement(); // следующий ключ
			columns += element + (e.hasMoreElements() ? "," : "");
			value += "'" + values.get(element) + "'" + (e.hasMoreElements() ? "," : "");
		}
		query += "(" + columns + ") VALUES (" + value + ")";


		stmt = getConnect().prepareStatement(query);
		int count = stmt.executeUpdate(query);

		return count;

	}

	/**
	 * Метод для удаления либо обновления строки в таблице
	 * 
	 * @param SQL запрос
	 * @return <b>int</b> количество измененных записей
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public static int updateTable(String SQL) throws SQLException, ClassNotFoundException {
		int count = 0;
		stmt = getConnect().prepareStatement(SQL);
		count = stmt.executeUpdate(SQL);
		return count;
	}
}
