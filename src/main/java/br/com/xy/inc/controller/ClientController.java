package br.com.xy.inc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.xy.inc.dao.ClientDAO;
import br.com.xy.inc.model.Client;


@Controller
public class ClientController {
	
	@Autowired
	private ClientDAO clientDAO;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("clientlist")
	public String retrieveClients(Model model){
		
		Iterable<Client> clientList = clientDAO.retrieveAll();
		model.addAttribute("client", clientList);
		
		return "clientlist";
	}
	
	@RequestMapping(value = "createclient", method = RequestMethod.POST)
	public String createClient(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("telephone") String telephone, Model model){
		
		Client client = new Client(name, email, telephone);
		clientDAO.create(client);
		Iterable<Client> clients = (Iterable<Client>) clientDAO.retrieveAll();
		model.addAttribute("client", clients);
		
		return "redirect:clientlist";		
	}
	
}