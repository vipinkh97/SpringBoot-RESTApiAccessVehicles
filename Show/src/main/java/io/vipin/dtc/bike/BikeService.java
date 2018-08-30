package io.vipin.dtc.bike;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BikeService {
	
	@Autowired
	private BikeRepository bikeRepository;
	
	public List<Bike> getAllBikes(){
		List<Bike> bikes=new ArrayList<>();
		bikeRepository.findAll()
		.forEach(bikes::add);
		return bikes;
	}
	
	public Bike getBike(String id) {
		Bike bk;
		bk= bikeRepository.findById(id).get();
		return bk;
	}

	public void addBike(Bike bike) {
		bikeRepository.save(bike);
	}
	
	public List<Bike> addNewBike(String name,int price,int quantity,int year) {
		String id=name.toLowerCase();
		Bike bk=new Bike(id,name,price,quantity,year);
		bikeRepository.save(bk);
		List<Bike> bikes=new ArrayList<>();
		bikeRepository.findAll()
		.forEach(bikes::add);
		return bikes;
	}

	public Bike updateBike(String id,String name,int price,int quantity,int year) {
		Bike bk=new Bike(id,name,price,quantity,year);
		bikeRepository.save(bk);
		Bike bk1;
		bk1= bikeRepository.findById(id).get();
		return bk1;
	}

	public void deleteBike(String id) {
		bikeRepository.deleteById(id);
	}

	
	public Map<String,Integer> getBikeByPrice() {
		Map<String,Integer> obj=new HashMap<>();
		List<Bike> bikes=getAllBikes();
		for(Bike bike:bikes) {
			obj.put(bike.getName(), bike.getPrice());
		}
		return obj;
	}
	
	public Map<String,Integer> getBikeByQuantity() {
		Map<String,Integer> obj=new HashMap<>();
		List<Bike> bikes=getAllBikes();
		for(Bike bike:bikes) {
			obj.put(bike.getName(), bike.getQuantity());
		}
		return obj;
	}
	

}
