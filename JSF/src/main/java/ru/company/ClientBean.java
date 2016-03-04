package ru.company;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.company.model.entity.Client;
import ru.company.model.manager.Manager;
 
@Component
@Scope("session")
public class ClientBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private Manager manager;
	
	private Integer id;
	private String name;
	private String surname;	
    private Date date;
	 
	public List<Client> getClients() { 
		return manager.getClients(null); 
	}
	
	public String addAction() { 
		Client client = new Client();
		client.setId(this.id);
		client.setName(this.name);
		client.setSurname(this.surname);
		client.setDate(this.date);
		manager.addClient(client);
		
		return null;
	}
 
	public String deleteAction(Client client) {    
		manager.deleteClient(client.getId());
		return null;
	}
	
	public String updateAction(Client client) {
		manager.updateClient(client);
		return null;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
}