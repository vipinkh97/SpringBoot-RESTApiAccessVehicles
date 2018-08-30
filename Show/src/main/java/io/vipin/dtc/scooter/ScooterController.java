package io.vipin.dtc.scooter;

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
import io.vipin.dtc.vehicle.Vehicle;

@Controller
public class ScooterController {
	
	@Autowired
	private ScooterService scooterService;
	
	@RequestMapping(method=RequestMethod.GET,value="/scooters")
	public String getAllScooters(Model model){
	model.addAttribute("scooters", scooterService.getAllScooters());
		return "scooters";
	}
	
	@RequestMapping("/scooters/{id}")
	public String getScooter(@PathVariable String id,Model model) {
		model.addAttribute("scooters", scooterService.getScooter(id));
		Scooter sc=scooterService.getScooter(id);
		System.out.println(sc.getName());
		System.out.println(sc.getPrice());
		System.out.println(sc.getQuantity());
		System.out.println(sc.getYearofmfg());
		return "scooterbyId";
	}

	@RequestMapping("/scooters/price")
	public Map<String,Integer> getScooterByPrice() {
		return scooterService.getScooterByPrice();
	}
	
	@RequestMapping("/scooters/quantity")
	public Map<String,Integer> getScooterByQuantity() {
		return scooterService.getScooterByQuantity();
	}
	
	
	@PostMapping("/scooters")
	public String addScooter(HttpServletRequest request,HttpServletResponse response,Model model) {
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String quantity=request.getParameter("quantity");
		String year=request.getParameter("year");
		model.addAttribute("scooters",scooterService.addNewScooter(name,Integer.valueOf(price),Integer.valueOf(quantity),
		Integer.valueOf(year)));
		return "scooters";
	}
	
	@GetMapping("/scooters/{id}/update")
	public String updateScooterForm(@PathVariable String id,Model model,HttpServletRequest request,HttpServletResponse response) {
		model.addAttribute("scootersup",scooterService.getScooter(id));
		return "updateBike";
	}
	
	@PostMapping("/scooters/{id}/update")
	public void updateScooter(@PathVariable String id,Model model,HttpServletRequest request,HttpServletResponse response) {
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String quantity=request.getParameter("quantity");
		String year=request.getParameter("year");
		model.addAttribute("scooters",scooterService.updateScooter(id,name,Integer.valueOf(price),Integer.valueOf(quantity),Integer.valueOf(year)));
		Scooter sk=scooterService.updateScooter(id,name,Integer.valueOf(price),Integer.valueOf(quantity),Integer.valueOf(year));
		try {
			response.sendRedirect("/Show/scooters");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/scooters/{id}/delete")
	public String deleteScooterForm(@PathVariable String id,Model model,HttpServletRequest request,HttpServletResponse response) {
		model.addAttribute("scootersup",scooterService.getScooter(id));
		return "deleteBike";
	}
	
	@PostMapping("/scooters/{id}/delete")
	public void deleteScooter(@PathVariable String id,HttpServletResponse response) {
		scooterService.deleteScooter(id);
		try {
			response.sendRedirect("/Show/scooters");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
