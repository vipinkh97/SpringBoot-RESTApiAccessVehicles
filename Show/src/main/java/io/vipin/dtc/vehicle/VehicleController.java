package io.vipin.dtc.vehicle;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.vipin.dtc.bike.Bike;

@Controller
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(method=RequestMethod.GET,value="/vehicles")
	public String getAllVehicles(Model model){
		model.addAttribute("vehicles", vehicleService.getAllVehicle());
		return "vehicles";
	}
	
	@RequestMapping("/vehicles/{id}")
	public String getVehicle(@PathVariable String id,Model model) {
		model.addAttribute("vehicles", vehicleService.getVehicle(id));
		return "vehiclebyId";
	}
	
	HttpServletRequest request;
	
	@PostMapping("/vehicles")
	public String addVehicle(HttpServletRequest request,HttpServletResponse response,Model model) {
		String type=request.getParameter("type");
		String minprice=request.getParameter("minprice");
		String maxprice=request.getParameter("maxprice");
		model.addAttribute("vehicles",vehicleService.addNewVehicle(type,Integer.valueOf(minprice),Integer.valueOf(maxprice)));
		return "vehicles";
	}
	
	@GetMapping("/vehicles/{id}/update")
	public String updateVehicleForm(@PathVariable String id,Model model,HttpServletRequest request,HttpServletResponse response) {
		model.addAttribute("vehiclesup",vehicleService.getVehicle(id));
		return "updateVehicle";
	}
	
	@PostMapping("/vehicles/{id}/update")
	public void updateVehicle(@PathVariable String id,Model model,HttpServletRequest request,HttpServletResponse response) {
		String name=request.getParameter("name");
		String minprice=request.getParameter("minprice");
		String maxprice=request.getParameter("maxprice");
		model.addAttribute("vehicles",vehicleService.updateVehicle(id,name,Integer.valueOf(minprice),Integer.valueOf(maxprice)));
		try {
			response.sendRedirect("/Show/vehicles");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/vehicles/{id}/delete")
	public String deleteVehicleForm(@PathVariable String id,Model model,HttpServletRequest request,HttpServletResponse response) {
		model.addAttribute("vehiclesup",vehicleService.getVehicle(id));
		return "deleteVehicle";
	}
	
	@PostMapping("/vehicles/{id}/delete")
	public void deleteVehicle(@PathVariable String id,HttpServletResponse response) {
		vehicleService.deleteVehicle(id);
		try {
			response.sendRedirect("/Show/vehicles");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
