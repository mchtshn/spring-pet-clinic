package com.mucahit.petclinic.petclinic.bootstrap;

import com.mucahit.petclinic.petclinic.model.Owner;
import com.mucahit.petclinic.petclinic.model.Pet;
import com.mucahit.petclinic.petclinic.model.PetType;
import com.mucahit.petclinic.petclinic.model.Vet;
import com.mucahit.petclinic.petclinic.services.OwnerService;
import com.mucahit.petclinic.petclinic.services.PetTypeService;
import com.mucahit.petclinic.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded pet types..");

        Owner mucahit = new Owner();
        mucahit.setFirstName("Mucahit");
        mucahit.setLastName("Sahin");
        mucahit.setAddress("Bla Bla");
        mucahit.setCity("Istanbul");
        mucahit.setTelephone("111-111-1111");

        Pet mucahitsPet = new Pet();
        mucahitsPet.setPetType(savedDogPetType);
        mucahitsPet.setOwner(mucahit);
        mucahitsPet.setBirthDate(LocalDate.now());
        mucahitsPet.setName("Pamuk");
        mucahit.getPets().add(mucahitsPet);

        ownerService.save(mucahit);

        Owner fatih = new Owner();
        fatih.setFirstName("Fatih");
        fatih.setLastName("Sahin");
        fatih.setAddress("Bla Bla Bla");
        fatih.setCity("Istanbul");
        fatih.setTelephone("222-222-2222");

        Pet fatihsPet = new Pet();
        fatihsPet.setPetType(savedDogPetType);
        fatihsPet.setOwner(fatih);
        fatihsPet.setBirthDate(LocalDate.now());
        fatihsPet.setName("Karabaş");
        fatih.getPets().add(fatihsPet);

        ownerService.save(fatih);

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
