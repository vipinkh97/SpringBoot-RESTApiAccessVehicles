package io.vipin.dtc.car;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.vipin.dtc.bike.Bike;

@Controller
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@RequestMapping(method=RequestMethod.GET,value="/cars")
	public String getAllCars(Model model){
		model.addAttribute("cars", carService.getAllCars());
		return "cars";
	}
	
	@RequestMapping("/cars/{id}")
	public String getCar(@PathVariable String id,Model model) {
		model.addAttribute("cars",carService.getCar(id));
		return "carbyId";
	}

	@RequestMapping("/cars/price")
	public Map<String,Integer> getCarByPrice() {
		return carService.getCarByPrice();
	}
	
	@RequestMapping("/cars/quantity")
	public Map<String,Integer> getCarByQuantity() {
		return carService.getCarByQuantity();
	}
	
	
	@PostMapping("/cars")
	public String addCar(HttpServletRequest request,HttpServletResponse response,Model model) {
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String quantity=request.getParameter("quantity");
		String year=request.getParameter("year");
		model.addAttribute("cars",carService.addNewCar(name, Integer.valueOf(price), Integer.valueOf(quantity), 
				Integer.valueOf(year)));
		return "cars";
	}
	
	@GetMapping("/cars/{id}/update")
	public String updateCarForm(@PathVariable String id,Model model,HttpServletRequest request,HttpServletResponse response) {
		model.addAttribute("carsup",carService.getCar(id));
		return "updateCar";
	}
	
	@PostMapping("/cars/{id}/update")
	public void updateCar(@PathVariable String id,Model model,HttpServletRequest request,HttpServletResponse response) {
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String quantity=request.getParameter("quantity");
		String year=request.getParameter("year");
		model.addAttribute("cars",carService.updateCar(id,name,Integer.valueOf(price),Integer.valueOf(quantity),Integer.valueOf(year)));
		Car ck=carService.updateCar(id,name,Integer.valueOf(price),Integer.valueOf(quantity),Integer.valueOf(year));
		try {
			response.sendRedirect("/Show/cars");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/cars/{id}/delete")
	public String deleteCarForm(@PathVariable String id,Model model,HttpServletRequest request,HttpServletResponse response) {
		model.addAttribute("carsup",carService.getCar(id));
		return "deleteCar";
	}
	
	@PostMapping("/cars/{id}/delete")
	public void deleteCar(@PathVariable String id,HttpServletResponse response) {
		carService.deleteCar(id);
		try {
			response.sendRedirect("/Show/cars");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
