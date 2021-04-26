package com.mucahit.petclinic.petclinic.bootstrap;

import com.mucahit.petclinic.petclinic.model.Owner;
import com.mucahit.petclinic.petclinic.model.Vet;
import com.mucahit.petclinic.petclinic.services.OwnerService;
import com.mucahit.petclinic.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Mucahit");
        owner1.setLastName("Sahin");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fatih");
        owner2.setLastName("Sahin");

        ownerService.save(owner2);

        System.out.println("Loaded owners..");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded vets..");

    }
}
