package com.mucahit.petclinic.petclinic.repositories;

import com.mucahit.petclinic.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
