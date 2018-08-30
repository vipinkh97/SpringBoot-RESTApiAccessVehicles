package io.vipin.dtc.bike;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BikeController {
	
	@Autowired
	private BikeService bikeService;
	
	@RequestMapping(method=RequestMethod.GET,value="/bikes")
	public String getAllBikes(Model model){
	model.addAttribute("bikes", bikeService.getAllBikes());
		return "bikes";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/bikes/{id}")
	public String getBike(@PathVariable String id,Model model) {
		model.addAttribute("bikes",bikeService.getBike(id));
		return "bikebyId";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/bikes/price")
	public Map<String,Integer> getBikeByPrice() {
		return bikeService.getBikeByPrice();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/bikes/quantity")
	public Map<String,Integer> getBikeByQuantity() {
		return bikeService.getBikeByQuantity();
	}

	
	@PostMapping("/bikes")
	public String addBike(HttpServletRequest request,HttpServletResponse response,Model model) {
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String quantity=request.getParameter("quantity");
		String year=request.getParameter("year");
		model.addAttribute("bikes",bikeService.addNewBike(name,Integer.valueOf(price),Integer.valueOf(quantity),Integer.valueOf(year)));
		return "bikes";
	}
	
	@GetMapping("/bikes/{id}/update")
	public String updateBikeForm(@PathVariable String id,Model model,HttpServletRequest request,HttpServletResponse response) {
		model.addAttribute("bikesup",bikeService.getBike(id));
		return "updateBike";
	}
	
	@PostMapping("/bikes/{id}/update")
	public void updateBike(@PathVariable String id,Model model,HttpServletRequest request,HttpServletResponse response) {
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String quantity=request.getParameter("quantity");
		String year=request.getParameter("year");
		model.addAttribute("bikes",bikeService.updateBike(id,name,Integer.valueOf(price),Integer.valueOf(quantity),Integer.valueOf(year)));
		Bike bk=bikeService.updateBike(id,name,Integer.valueOf(price),Integer.valueOf(quantity),Integer.valueOf(year));
		try {
			response.sendRedirect("/Show/bikes");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/bikes/{id}/delete")
	public String deleteBikeForm(@PathVariable String id,Model model,HttpServletRequest request,HttpServletResponse response) {
		model.addAttribute("bikesup",bikeService.getBike(id));
		return "deleteBike";
	}
	
	@PostMapping("/bikes/{id}/delete")
	public void deleteBike(@PathVariable String id,HttpServletResponse response) {
		bikeService.deleteBike(id);
		try {
			response.sendRedirect("/Show/bikes");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
