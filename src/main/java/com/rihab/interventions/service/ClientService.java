package com.rihab.interventions.service;

import java.util.List;

import com.rihab.interventions.entities.Client;

public interface ClientService {

	Client saveClient(Client client);
	Client updateClient(Client client);
void deleteClient(Client client);
 void deleteClientByCodeClient(String code);
 Client getClient(String code);
List<Client> getAllClients();

}
