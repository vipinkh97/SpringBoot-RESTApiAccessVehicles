package io.vipin.dtc.bike;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bike {
	
	@Id
	private String id;
	private String name;
	private int price;
	private int quantity;
	private int yearofmfg;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getYearofmfg() {
		return yearofmfg;
	}

	public void setYearofmfg(int yearofmfg) {
		this.yearofmfg = yearofmfg;
	}

	
	public Bike() {
		
	}
	
	public Bike(String id, String name, int price, int quantity, int yearofmfg) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.yearofmfg = yearofmfg;
	}
	

	
}
