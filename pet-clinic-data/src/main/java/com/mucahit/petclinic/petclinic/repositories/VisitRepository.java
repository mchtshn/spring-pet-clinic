package com.mucahit.petclinic.petclinic.repositories;

import com.mucahit.petclinic.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
