package com.mucahit.petclinic.petclinic.repositories;

import com.mucahit.petclinic.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
