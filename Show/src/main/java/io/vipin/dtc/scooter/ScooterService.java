package io.vipin.dtc.scooter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.vipin.dtc.bike.Bike;
import io.vipin.dtc.vehicle.Vehicle;


@Service
public class ScooterService {
	
	@Autowired
	private ScooterRepository scooterRepository;
	
	public List<Scooter> getAllScooters(){
		List<Scooter> scooters=new ArrayList<>();
		scooterRepository.findAll()
		.forEach(scooters::add);
		return scooters;
	}
	
	public Scooter getScooter(String id) {
		Scooter sc;
		sc=scooterRepository.findById(id).get();
		return sc;
	}

	public void addScooter(Scooter bike) {
		scooterRepository.save(bike);
	}

	public List<Scooter> addNewScooter(String name,Integer price,Integer quantity,Integer year) {
		String id=name.toLowerCase();
		Scooter sk=new Scooter(id,name,price,quantity,year);
		scooterRepository.save(sk);
		List<Scooter> scooters=new ArrayList<>();
		scooterRepository.findAll()
		.forEach(scooters::add);
		return scooters;
	}
	
	public Scooter updateScooter(String id,String name,int price,int quantity,int year) {
		Scooter sk=new Scooter(id,name,price,quantity,year);
		scooterRepository.save(sk);
		Scooter sk1;
		sk1= scooterRepository.findById(id).get();
		return sk1;
	}

	public void deleteScooter(String id) {
		scooterRepository.deleteById(id);
	}

	
	public Map<String,Integer> getScooterByPrice() {
		Map<String,Integer> obj=new HashMap<>();
		List<Scooter> bikes=getAllScooters();
		for(Scooter bike:bikes) {
			obj.put(bike.getName(), bike.getPrice());
		}
		return obj;
	}
	
	public Map<String,Integer> getScooterByQuantity() {
		Map<String,Integer> obj=new HashMap<>();
		List<Scooter> bikes=getAllScooters();
		for(Scooter bike:bikes) {
			obj.put(bike.getName(), bike.getQuantity());
		}
		return obj;
	}
	

}
