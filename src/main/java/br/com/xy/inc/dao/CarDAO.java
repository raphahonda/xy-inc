package br.com.xy.inc.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.xy.inc.model.CarFleet;
import br.com.xy.inc.repository.CarRepository;

@Service
public class CarDAO {

	@Autowired
	private CarRepository carDAO;

	public void create(CarFleet carOrder){
		carDAO.save(carOrder);
	}	

	public CarFleet retrieve(Long id){
		return carDAO.findOne(id);
	}

	public ArrayList<CarFleet> retrieveAll(){

		ArrayList<CarFleet> clients = (ArrayList<CarFleet>) carDAO.findAll();
		return clients;
	}

	public CarFleet update(CarFleet car){

		CarFleet carItem = carDAO.findOne(car.getId());

		carItem.setModel(car.getModel());
		carItem.setPrice(car.getPrice());
		carItem.setPatrimonyTag(car.getPatrimonyTag());

		return carDAO.save(carItem);	
	}

	public void delete(Long id){
		carDAO.delete(id);
	}

}