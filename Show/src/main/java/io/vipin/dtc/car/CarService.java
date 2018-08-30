package io.vipin.dtc.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.vipin.dtc.bike.Bike;


@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	public List<Car> getAllCars(){
		List<Car> cars=new ArrayList<>();
		carRepository.findAll()
		.forEach(cars::add);
		return cars;
	}
	
	public Car getCar(String id) {
		Car ck;
		ck=carRepository.findById(id).get();
		return ck;
	}

	public void addCar(Car car) {
		carRepository.save(car);
	}
	
	public List<Car> addNewCar(String name,Integer price,Integer quantity,Integer year) {
		String id=name.toLowerCase();
		Car ck=new Car(id,name,price,quantity,year);
		carRepository.save(ck);
		List<Car> cars=new ArrayList<>();
		carRepository.findAll()
		.forEach(cars::add);
		return cars;
	}


	public Car updateCar(String id,String name,int price,int quantity,int year) {
		Car ck=new Car(id,name,price,quantity,year);
		carRepository.save(ck);
		Car ck1;
		ck1= carRepository.findById(id).get();
		return ck1;
	}

	public void deleteCar(String id) {
		carRepository.deleteById(id);
	}


	
	public Map<String,Integer> getCarByPrice() {
		Map<String,Integer> obj=new HashMap<>();
		List<Car> cars=getAllCars();
		for(Car car:cars) {
			obj.put(car.getName(), car.getPrice());
		}
		return obj;
	}
	
	public Map<String,Integer> getCarByQuantity() {
		Map<String,Integer> obj=new HashMap<>();
		List<Car> cars=getAllCars();
		for(Car car:cars) {
			obj.put(car.getName(), car.getQuantity());
		}
		return obj;
	}

}
