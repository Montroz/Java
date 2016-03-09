package ru.company.jsf.model.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.company.jsf.model.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
@Transactional
public class JpaClientDao implements ClientDao {

	@PersistenceContext(unitName="ClientsService")
	private EntityManager em;

	public void addClient(Client client) {
		    em.persist(client);
	}

	public Client getClient(Integer id) {
		return em.find(Client.class, id);
	}

	public void updateClient(Client updatedClient) {

		Client oldClient = em.find(Client.class, updatedClient.getId());

		if (oldClient!=null) {

			//обновляем
			oldClient.setId(updatedClient.getId());
			oldClient.setName(updatedClient.getName());
			oldClient.setSurname(updatedClient.getSurname());
			oldClient.setBirthday(updatedClient.getBirthday());
			oldClient.setHeight(updatedClient.getHeight());
			

			em.merge(oldClient);
		} else {
			//TODO не нашли запись
			return;
		}
	}

	public List<Client> getList(String search) {
		List<Client> list = null;

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Client> cq = cb.createQuery(Client.class);
		Root<Client> fromClient = cq.from(Client.class);
		cq.select(fromClient);

		list = em.createQuery(cq).getResultList();
		return list;
	}

	public void deleteClient(Integer id) {

		Client client = em.find(Client.class, id);
		em.remove(client);
	}
}
