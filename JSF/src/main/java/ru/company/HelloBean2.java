package ru.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.company.model.manager.Manager;

import java.io.Serializable;

@Component
@Scope("session")
public class HelloBean2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	@Autowired
	private Manager manager;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSayWelcome() {
		// check if null?
		if ("".equals(name) || name == null) {
			return "";
		} else {
			System.out.println(manager);
			return "Ajax message : Welcome " + name + manager;
		}
	}
}