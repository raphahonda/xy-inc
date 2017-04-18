package br.com.xy.inc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.xy.inc.dao.SupplierDAO;
import br.com.xy.inc.model.Supplier;


@Controller
public class SupplierController {
	
	@Autowired
	private SupplierDAO supplierDAO;
		
	@RequestMapping("supplierlist")
	public String retrieveSuppliers(Model model){
		
		Iterable<Supplier> supplierList = supplierDAO.retrieveAll();
		model.addAttribute("supplier", supplierList);
		
		return "supplierlist";
	}
	
	@RequestMapping(value = "createSupplier", method = RequestMethod.POST)
	public String createSupplier(@RequestParam("name") String name, @RequestParam("lineOfBusiness") String lineOfBusiness, @RequestParam("telephone") String telephone, Model model){
		
		Supplier supplier = new Supplier(name, lineOfBusiness, telephone);
		supplierDAO.create(supplier);
		Iterable<Supplier> suppliers = (Iterable<Supplier>) supplierDAO.retrieveAll();
		model.addAttribute("supplier", suppliers);
		
		return "redirect:supplierlist";		
	}
}