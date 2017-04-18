package br.com.xy.inc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.xy.inc.dao.CarDAO;
import br.com.xy.inc.model.CarFleet;


@Controller
public class CarController {
	
	@Autowired
	private CarDAO carDAO;
		
	@RequestMapping("carfleetlist")
	public String retrievefleet(Model model){
		
		Iterable<CarFleet> carList = carDAO.retrieveAll();
		model.addAttribute("car", carList);
				
		return "carfleetlist";
	}
	
	@RequestMapping(value = "createCar", method = RequestMethod.POST)
	public String createCar(@RequestParam("modelName") String modelName, @RequestParam("price") Double price, @RequestParam("patrimonyTag") String patrimonyTag, Model model){
		
		CarFleet carFleet = new CarFleet(modelName, price, patrimonyTag);
		carDAO.create(carFleet);
		Iterable<CarFleet> carFleets = (Iterable<CarFleet>) carDAO.retrieveAll();
		model.addAttribute("car", carFleets);
		
		return "redirect:carfleetlist";		
	}
}