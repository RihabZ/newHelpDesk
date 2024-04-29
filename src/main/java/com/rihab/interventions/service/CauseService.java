package com.rihab.interventions.service;

import java.util.List;

import com.rihab.interventions.entities.Cause;

public interface CauseService {


	Cause saveCause(Cause cause);
	Cause updateCause(Cause cause);
	void deleteCause(Cause cause);
	void deleteCauseByCodeCause(long id);
	Cause getCause(long id);
		List<Cause> getAllCauses();


}
