package br.com.xy.inc.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.xy.inc.model.Supplier;
import br.com.xy.inc.repository.SupplierRepository;

@Service
public class SupplierDAO {

	@Autowired
	private SupplierRepository supplierDAO;

	public void create(Supplier supplier){
		supplierDAO.save(supplier);
	}

	public Supplier retrieve(Long id){
		return supplierDAO.findOne(id);
	}	

	public ArrayList<Supplier> retrieveAll(){

		ArrayList<Supplier> suppliers = (ArrayList<Supplier>) supplierDAO.findAll();
		return suppliers;
	}

	public Supplier update(Supplier supplier){

		Supplier supp = supplierDAO.findOne(supplier.getId());

		supp.setName(supplier.getName());
		supp.setLineOfBusiness(supplier.getLineOfBusiness());
		supp.setTelephone(supplier.getTelephone());

		return supplierDAO.save(supp);	
	}

	public void delete(Long id){
		supplierDAO.delete(id);
	}
}