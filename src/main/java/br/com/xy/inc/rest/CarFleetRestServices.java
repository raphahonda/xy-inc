package br.com.xy.inc.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.xstream.XStream;

import br.com.xy.inc.dao.CarDAO;
import br.com.xy.inc.model.CarFleet;

@RestController
public class CarFleetRestServices {

	@Autowired
	private CarDAO carDAO;	

	@RequestMapping(path = "/getcarservice/{id}", method = RequestMethod.GET)
	public @ResponseBody String getCar(@PathVariable Long id) {

		CarFleet car = carDAO.retrieve(id);			
		return car.toXML();
	}
	
	@RequestMapping(path = "/fleet", method = RequestMethod.GET)
	public @ResponseBody String getAllCars() {

		ArrayList<CarFleet> cars = carDAO.retrieveAll();	
		return new XStream().toXML(cars);
	}	
	
	@RequestMapping("/createcarservice/{modelName}/{price}/{patrimonyTag}")
	public String createCarService(@PathVariable String modelName, @PathVariable Double price, @PathVariable String patrimonyTag, Model model) {

		CarFleet carItem = new CarFleet(modelName, price, patrimonyTag);
		carDAO.create(carItem);
		return carItem.toXML();
	}
	
	@RequestMapping("/updatecarservice/{id}/{modelName}/{price}/{patrimonyTag}")
	public String updateCarService(@PathVariable Long id, @PathVariable String modelName, @PathVariable Double price, @PathVariable String patrimonyTag, Model model) {

		CarFleet carItem = carDAO.retrieve(id);
		carItem.setModel(modelName);
		carItem.setPrice(price);
		carItem.setPatrimonyTag(patrimonyTag);
		
		carDAO.update(carItem);
		return carItem.toXML();
	}
	
	@RequestMapping(path = "/removecarservice/{id}")
	public String deleteCarService(@PathVariable Long id) {
		
		try{ 
			
			carDAO.delete(id);
			return new XStream().toXML(new Boolean("true"));
		
		}catch (Exception e) {
			return new XStream().toXML(new Boolean("false"));
		}		
	}
}