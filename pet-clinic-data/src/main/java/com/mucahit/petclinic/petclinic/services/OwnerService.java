package com.mucahit.petclinic.petclinic.services;

import com.mucahit.petclinic.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
