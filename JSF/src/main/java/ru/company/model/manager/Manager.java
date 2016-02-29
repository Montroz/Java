package ru.company.model.manager;


import ru.company.model.dao.ClientDao;
import ru.company.model.entity.Client;

import java.util.List;


public class Manager {

    private ClientDao clientDao;

    public List<Client> getClients(String search) {
        return clientDao.getList(search);
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
