package com.rihab.interventions.service;

import java.util.List;

import com.rihab.interventions.entities.Manager;

public interface ManagerService {


	Manager saveManager(Manager manager);
	Manager updateManager(Manager manager);
void deleteManager(Manager manager);
 void deleteManagerByCode(long code);
 Manager getManager(long code);
List<Manager> getAllManagers();

}
