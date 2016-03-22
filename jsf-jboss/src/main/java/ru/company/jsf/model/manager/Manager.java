package ru.company.jsf.model.manager;



import java.util.List;

import ru.company.jsf.model.dao.ClientDao;
import ru.company.jsf.model.entity.Client;


public class Manager {

    private ClientDao clientDao;

    public List<Client> getClients(String search) {
        return clientDao.getList(search);
    }

	public Client getClient(Integer id) {
		return clientDao.getClient(id);
	}
	
    public void addClient(Client client) {
        clientDao.addClient(client);
    }

    public void updateClient(Client client) {
        clientDao.updateClient(client);
    }

    public void deleteClient(Integer id) {
        clientDao.deleteClient(id);
    }
    
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }
}
