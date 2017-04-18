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

import br.com.xy.inc.dao.ClientDAO;
import br.com.xy.inc.model.Client;


@RestController
public class ClientRestServices {

	@Autowired
	private ClientDAO clientDAO;	
	

	@RequestMapping(path = "/getclientservice/{id}", method = RequestMethod.GET)
	public @ResponseBody String getClient(@PathVariable Long id) {

		Client client = clientDAO.retrieve(id);			
		return client.toXML();
	}
	
	@RequestMapping(path = "/allclientsservice", method = RequestMethod.GET)
	public @ResponseBody String getAllClients() {

		ArrayList<Client> clients = clientDAO.retrieveAll();	
		return new XStream().toXML(clients);
	}	
	
	@RequestMapping("/createclientservice/{name}/{email}/{telephone}")
	public String createClientService(@PathVariable String name, @PathVariable String email, @PathVariable String telephone, Model model) {

		Client client = new Client(name, email, telephone);
		clientDAO.create(client);
		return client.toXML();
	}
	
	@RequestMapping("/updateclientservice/{id}/{name}/{email}/{telephone}")
	public String updateClientService(@PathVariable Long id, @PathVariable String name, @PathVariable String email, @PathVariable String telephone, Model model) {

		Client client = clientDAO.retrieve(id);
		client.setName(name);
		client.setEmail(email);
		client.setTelephone(telephone);
		
		clientDAO.update(client);
		return client.toXML();
	}
	
	@RequestMapping(path = "/removeclientservice/{id}")
	public String deleteClientService(@PathVariable Long id) {
		
		try{ 
			
			clientDAO.delete(id);
			return new XStream().toXML(new Boolean("true"));
		
		}catch (Exception e) {
			return new XStream().toXML(new Boolean("false"));
		}		
	}
}