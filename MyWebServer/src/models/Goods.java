package models;

public class Goods {
	private String type, title, price, image, id_good;

	public Goods(String id_good, String title, String type, String price, String image) {
		this.id_good = id_good;
		this.title = title;
		this.type = type;
		this.price = price;
		this.image = image;
	}	
	
	
	public String getType() {
		return type;
	}


	public String getTitle() {
		return title;
	}


	public String getPrice() {
		return price;
	}


	public String getImage() {
		return image;
	}
	
	public String getId_good() {
		return id_good;
	}

}
