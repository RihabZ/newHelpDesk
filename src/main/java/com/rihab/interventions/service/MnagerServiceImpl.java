package com.rihab.interventions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihab.interventions.entities.Manager;
import com.rihab.interventions.repos.ManagerRepository;

@Service
public class MnagerServiceImpl  implements ManagerService {
	
	@Autowired
	ManagerRepository managerRepository;



@Override
public Manager saveManager(Manager demandeur)
{
return managerRepository.save(demandeur);

}

@Override
public Manager updateManager(Manager demandeur) {
return managerRepository.save(demandeur);
}


@Override
public void deleteManager(Manager demandeur) {
	managerRepository.delete(demandeur);
}


@Override
public void deleteManagerByCode(long code) {
	managerRepository.deleteById(code);
}


@Override
public Manager getManager(long code) {
return managerRepository.findById(code).get();
}


@Override
public List<Manager> getAllManagers() {
return managerRepository.findAll();
}



}
