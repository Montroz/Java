package ru.company.model.dao;

import org.springframework.stereotype.Repository;
import ru.company.model.entity.Client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class StubDao implements ClientDao {

	public void addClient(Client client) {
	}

	public Client getClient(Integer id) {
		return new Client();
	}

	public void updateClient(Client updatedClient) {
	}

	public List<Client> getList(String search) {
		List<Client> list = new ArrayList<Client>();

		Client client = new Client();
		client.setId(1);
		client.setText("");

		client.setDate(new Date());
        list.add(client);
		return list;
	}

	public void deleteClient(Integer id) {
	}
}
