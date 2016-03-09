package ru.company.jsf.service;

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

 
@Component
@Scope("session")
public class ClientBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private Manager manager;
	
	private Integer id;
	private String name;
	private String surname;	
    private Date birthday;
    private Integer height;
    
    private Integer num = 10000;
	
	public String addAction() { 
		Client client = new Client();
		//client.setId(num);
		client.setName(this.name);
		client.setSurname(this.surname);
		//client.setDate(this.date);
		manager.addClient(client);
		num++;
		
		clearForm();
		return "directory";
	}
	
	private void clearForm() {
		id = null;
		name = null;
		surname = null;	
	    birthday = null;
	    height = null;
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