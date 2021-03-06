package ru.company.jsf.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.company.jsf.model.entity.Client;
import ru.company.jsf.model.manager.Manager;

 
@Component
@Scope("request")
public class ClientListBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private Manager manager;
	
	@PostConstruct
	public void init() {
		System.out.println("Создан ClientListBean");
	}
	 
	public List<Client> getClients() { 
		return manager.getClients(null); 
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