package io.vipin.dtc.vehicle;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.vipin.dtc.bike.Bike;

@Service
public class VehicleService {
	
	HttpServletRequest request;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public List<Vehicle> getAllVehicle(){

		List<Vehicle> vehicles=new ArrayList<>();
		vehicleRepository.findAll()
		.forEach(vehicles::add);
		return vehicles;
	}
	
	public Vehicle getVehicle(String id) {
		Vehicle veh;
		veh=vehicleRepository.findById(id).get();
		return veh;
	}

	public void addVehicles(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	public Vehicle updateVehicle(String id,String name,Integer minprice,Integer maxprice) {
		Vehicle vk=new Vehicle(id,name,minprice,maxprice);
		vehicleRepository.save(vk);
		Vehicle vk1;
		vk1= vehicleRepository.findById(id).get();
		return vk1;
	}

	public void deleteVehicle(String id) {
		vehicleRepository.deleteById(id);
	}

	public List<Vehicle> addNewVehicle(String name,Integer minprice,Integer maxprice) {
		String id=name.toLowerCase();
		Vehicle vk=new Vehicle(id,name,minprice,maxprice);
		vehicleRepository.save(vk);
		List<Vehicle> vehicles=new ArrayList<>();
		vehicleRepository.findAll()
		.forEach(vehicles::add);
		return vehicles;
	}
	
	

}
