package com.rihab.interventions.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rihab.interventions.entities.Client;
import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.service.ClientService;
import com.rihab.interventions.service.EquipementService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClientRESTController {
	
	@Autowired
	ClientService clientService;

	@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(path="allClients",method = RequestMethod.GET)
public List<Client> getAllClients() {
	return clientService.getAllClients();
}


@RequestMapping(value="/getbycodeClient/{codeClient}",method = RequestMethod.GET)
public Client getClientById(@PathVariable("codeClient") String codeClient) {
	return clientService.getClient(codeClient);
 }

//autorisation au admin seulement cette methode
@RequestMapping(path="/addclient",method = RequestMethod.POST)

public Client createClient(@RequestBody Client client) {
	return clientService.saveClient(client);
}


@RequestMapping(path="/updateclient",method = RequestMethod.PUT)

public Client updateClient(@RequestBody Client client) {
		return clientService.updateClient(client);
}

//autorisation au admin seulement cette methode
@RequestMapping(value="/deleteclient/{codeClient}",method = RequestMethod.DELETE)
@PreAuthorize("hasAuthority('ADMIN')")
public void deleteClient(@PathVariable("codeClient") String codeClient)
{
	clientService.deleteClientByCodeClient(codeClient);
}


}
