package ru.company.model.entity;

import java.util.Collections;
import java.util.Date;
import java.util.Set;



public class Client {

	private Integer id;

	private String name;

	private String surname;
	
    private Date date;
	
	private Set<Worker> workers = Collections.EMPTY_SET;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers( Set<Worker> workers ) {
		if (workers != Collections.EMPTY_SET) {
			for (Worker element : workers) {
				element.setClient(this);
			}
			this.workers = workers;
		}
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", surname=" + surname + ", date=" + date + ", workers="
				+ workers + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}