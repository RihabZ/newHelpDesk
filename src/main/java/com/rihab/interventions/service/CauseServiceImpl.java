package com.rihab.interventions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihab.interventions.entities.Cause;
import com.rihab.interventions.repos.CauseRepository;


@Service
public class CauseServiceImpl implements CauseService {
	
	@Autowired
	CauseRepository causeRepository;



@Override
public Cause saveCause(Cause cause)
{
return causeRepository.save(cause);

}

@Override
public Cause updateCause(Cause cause) {
return causeRepository.save(cause);
}


@Override
public void deleteCause(Cause cause) {
	causeRepository.delete(cause);
}


@Override
public void deleteCauseByCodeCause(long id) {
	causeRepository.deleteById(id);
}


@Override
public Cause getCause(long id) {
return causeRepository.findById(id).get();
}


@Override
public List<Cause> getAllCauses() {
return causeRepository.findAll();
}





}
