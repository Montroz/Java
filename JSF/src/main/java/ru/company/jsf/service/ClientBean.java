package ru.company.jsf.service;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.company.jsf.model.entity.Client;
import ru.company.jsf.model.manager.Manager;

 
@Component
@ViewScoped
public class ClientBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private Manager manager;
	
	private Integer id;
	private Client client;
	
	@PostConstruct
	public void init() {
		client = new Client();
	}
    
    public void loadClient() {
        if (id == null) {
            String message = "Bad request. Please use a link from within the system.";
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
            return;
        }

        client = manager.getClient(id);

        if (client == null) {
            String message = "Bad request. Unknown id.";
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        }
    }
	
	public String addAction() { 
		manager.addClient(client);
		client = null;
		return "directory?faces-redirect=true";
	}
	
	public String updateAction() { 
		manager.updateClient(client);
		client = null;
		return "directory?faces-redirect=true";
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}