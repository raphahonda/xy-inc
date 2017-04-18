package br.com.xy.inc.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.xy.inc.model.Client;
import br.com.xy.inc.repository.ClientRepository;


@Service
public class ClientDAO {

	@Autowired
	private ClientRepository clientDAO;

	public void create(Client client){
		clientDAO.save(client);
	}
	
	public Client retrieve(Long id){
		return clientDAO.findOne(id);
	}
	
	public ArrayList<Client> retrieveAll(){

		ArrayList<Client> clients = (ArrayList<Client>) clientDAO.findAll();
		return clients;
	}
	
	public Client update(Client client){
		
		Client cli = clientDAO.findOne(client.getId());
		
		cli.setName(client.getName());
		cli.setEmail(client.getEmail());
		cli.setTelephone(client.getTelephone());
		
		return clientDAO.save(cli);	
	}
	
	public void delete(Long id){
		clientDAO.delete(id);
	}
}