package ru.company.jsf.model.dao;

import java.util.List;

import ru.company.jsf.model.entity.Client;


public interface ClientDao {

    public void addClient(Client client);

    public Client getClient(Integer id);

    public void updateClient(Client updatedClient);

    public void deleteClient(Integer id);

    public List<Client> getList(String search);
}
