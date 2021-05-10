package com.mucahit.petclinic.petclinic.services.map;

import com.mucahit.petclinic.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(),new PetTypeServiceMap());
        ownerServiceMap.save(Owner.builder().address("Bla bla").build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void save() {
        Owner owner = new Owner();
        owner.setId(2L);

        Owner savedOwner = ownerServiceMap.save(owner);

        assertEquals(2L,savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);
        assertEquals(1L,owner.getId());
    }

    @Test
    void findByLastName() {
    }
}