package ru.company.jsf.model.dao;

import org.springframework.stereotype.Repository;

import ru.company.jsf.model.entity.Client;
import ru.company.jsf.util.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StubDao implements ClientDao {
	
	private static final List<Client> clientList = 
			new ArrayList<Client>();
	
    private static SimpleDateFormat formatter =
            new SimpleDateFormat(Utils.DATE_FORMAT);
    
	static {
		try {
			Client cl1 = new Client();
			cl1.setId(1);
			cl1.setName("Иван");
			cl1.setSurname("Иванов");
			cl1.setBirthday(formatter.parse("01/01/1991"));
			clientList.add(cl1);
			
			Client cl2 = new Client();
			cl2.setId(2);
			cl2.setName("Петр");
			cl2.setSurname("Петров");
			cl2.setBirthday(formatter.parse("02/02/1992"));
			clientList.add(cl2);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addClient(Client client) {
		clientList.add(client);
	}

	public Client getClient(Integer id) {
		for (Client client: clientList) {
			if (client.getId().equals(id)) {
				return client;
			}
		}
		return null;
	}

	public void updateClient(Client updatedClient) {
		Client oldClient = getClient(updatedClient.getId());
		if (oldClient != null) {
			clientList.remove(oldClient);
			clientList.add(updatedClient);
		}
	}

	public List<Client> getList(String search) {
		return clientList;
	}

	public void deleteClient(Integer id) {
		Client client = getClient(id);
		if (client != null) {
			clientList.remove(client);
		}
	}
}
