package com.rihab.interventions.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rihab.interventions.entities.Cause;

public interface CauseRepository extends JpaRepository<Cause, Long> {

}
