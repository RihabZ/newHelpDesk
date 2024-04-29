package com.rihab.interventions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihab.interventions.entities.Client;
import com.rihab.interventions.repos.ClientRepository;
@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientRepository clientRepository;



@Override
public Client saveClient(Client client)
{
return clientRepository.save(client);

}

@Override
public Client updateClient(Client client) {
return clientRepository.save(client);
}


@Override
public void deleteClient(Client client) {
	clientRepository.delete(client);
}


@Override
public void deleteClientByCodeClient(String code) {
	clientRepository.deleteById(code);
}


@Override
public Client getClient(String code) {
return clientRepository.findById(code).get();
}


@Override
public List<Client> getAllClients() {
return clientRepository.findAll();
}




}
