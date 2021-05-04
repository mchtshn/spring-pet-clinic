package com.mucahit.petclinic.petclinic.repositories;

import com.mucahit.petclinic.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
