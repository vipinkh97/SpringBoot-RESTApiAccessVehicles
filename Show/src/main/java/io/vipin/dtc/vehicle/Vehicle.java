package io.vipin.dtc.vehicle;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {
	
	@Id
	private String id;
	private String name;
	private int minprice;
	private int maxprice;

	
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
	
	public Vehicle(String id, String name, int minprice, int maxprice) {
		super();
		this.id = id;
		this.name = name;
		this.minprice = minprice;
		this.maxprice = maxprice;
	}
	

	public int getMinprice() {
		return minprice;
	}
	public void setMinprice(int minprice) {
		this.minprice = minprice;
	}
	public int getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(int maxprice) {
		this.maxprice = maxprice;
	}
	public Vehicle() {
		
	}
	
	

}
