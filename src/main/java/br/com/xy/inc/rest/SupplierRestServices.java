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

import br.com.xy.inc.dao.SupplierDAO;
import br.com.xy.inc.model.Supplier;


@RestController
public class SupplierRestServices {

	@Autowired
	private SupplierDAO supplierDAO;	
	

	@RequestMapping(path = "/getsupplierservice/{id}", method = RequestMethod.GET)
	public @ResponseBody String getSupplier(@PathVariable Long id) {

		Supplier client = supplierDAO.retrieve(id);			
		return client.toXML();
	}
	
	@RequestMapping(path = "/allsuppliersservice", method = RequestMethod.GET)
	public @ResponseBody String getAllSuppliers() {

		ArrayList<Supplier> supplier = supplierDAO.retrieveAll();	
		return new XStream().toXML(supplier);
	}	
	
	@RequestMapping("/createsupplierservice/{name}/{lineOfBusiness}/{telephone}")
	public String createClientService(@PathVariable String name, @PathVariable String lineOfBusiness, @PathVariable String telephone, Model model) {

		Supplier supplier = new Supplier(name, lineOfBusiness, telephone);
		supplierDAO.create(supplier);
		return supplier.toXML();
	}
	
	@RequestMapping("/updatesupplierservice/{id}/{name}/{lineOfBusiness}/{telephone}")
	public String updateSupplierService(@PathVariable Long id, @PathVariable String name, @PathVariable String lineOfBusiness, @PathVariable String telephone, Model model) {

		Supplier supplier = supplierDAO.retrieve(id);
		supplier.setName(name);
		supplier.setLineOfBusiness(lineOfBusiness);
		supplier.setTelephone(telephone);
		
		supplierDAO.update(supplier);
		return supplier.toXML();
	}
	
	@RequestMapping(path = "/removesupplierservice/{id}")
	public String deleteSupplierService(@PathVariable Long id) {
		
		try{ 
			
			supplierDAO.delete(id);
			return new XStream().toXML(new Boolean("true"));
		
		}catch (Exception e) {
			return new XStream().toXML(new Boolean("false"));
		}		
	}
}