package ru.company.jsf.service.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.company.jsf.model.manager.Manager;

import java.io.Serializable;

@Component
@Scope("session")
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer name;

	@Autowired
	private Manager manager;

	public Integer getName() {
		return name;
	}

	public void setName(Integer name) {
		this.name = name;
	}

	public Integer getSayWelcome() {
		// check if null?
		if ("".equals(name) || name == null) {
			return 0;
		} else {
			System.out.println(manager);
			return name;
		}
	}
}