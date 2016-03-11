package ru.company.jsf.service.old;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.company.jsf.model.entity.Client;
import ru.company.jsf.model.manager.Manager;

 
@Scope("session")
public class OldClientBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private Manager manager;
	
	private Integer id;
	private String name;
	private String surname;	
    private Date birthday;
    private Integer height;
    
    private Integer num = 10000;
	 
	public List<Client> getClients() { 
		return manager.getClients(null); 
	}
	
	public String addAction() { 
		Client client = new Client();
		client.setId(num);
		client.setName(this.name);
		client.setSurname(this.surname);
		//client.setDate(this.date);
		manager.addClient(client);
		num++;
		
		clearForm(null);
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
	
	public void clearForm(ActionEvent e) {
		id = null;
		name = null;
		surname = null;	
	    birthday = null;
	    height = null;
	}
	
	public String editAction(Client client) {
		id = client.getId();
		name = client.getName();
		surname = client.getSurname();
		birthday = client.getBirthday();
		height = client.getHeight();
	    return null;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
	
}