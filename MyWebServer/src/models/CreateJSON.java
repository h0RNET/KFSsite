package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

//Для использования библиотеки javax.json необходимо скачать и установить драйвер javax.json - (версия).jar 

public class CreateJSON {

	static JsonObject getJSON(ResultSet rs) throws SQLException {
		
		JsonObjectBuilder jBuildObj = Json.createObjectBuilder(); //создаем строителя объекта Json  
		JsonArrayBuilder jBuildArray = Json.createArrayBuilder(); //создаем строителя массива Json
		JsonArray jarray = null; 
		JsonObject obj = null;
		JsonObjectBuilder jObj = Json.createObjectBuilder(); //
		String title;
		String price;
		String image;
		String idGood;
		try {
			while (rs.next()) {
				idGood = rs.getString("id_good");
				title = rs.getString("title");
				price = rs.getString("price");
				image = rs.getString("image");
				jObj.add("id_good", idGood);
				jObj.add("title", title); //добавляем в коллекцию типа HashMap пару ключ-значение
				jObj.add("price", price); 
				jObj.add("image", image);
				jBuildArray.add(jObj); //закидываем в массив наш построенный объект (скорее всего это коллекция типа ArrayList)	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jarray = jBuildArray.build(); //строим массив
		jBuildObj.add("allFoods", jarray); //закидываем массив в строящийся объект
		obj = jBuildObj.build(); //строим конечный объект
		return obj;
	}
}
