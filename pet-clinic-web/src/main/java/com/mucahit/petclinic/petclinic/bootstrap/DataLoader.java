package com.mucahit.petclinic.petclinic.bootstrap;

import com.mucahit.petclinic.petclinic.model.*;
import com.mucahit.petclinic.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded pet types..");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty saveRadiology = specialityService.save(radiology);

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");
        Specialty saveSurgery = specialityService.save(surgery);


        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");
        Specialty saveDentistry = specialityService.save(dentistry);

        System.out.println("Loaded specialies...");

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
        mucahitsPet.setName("Karabaş");
        mucahit.getPets().add(mucahitsPet);

        ownerService.save(mucahit);

        Visit dogVisit = new Visit();
        dogVisit.setPet(mucahitsPet);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Bla Bla");

        visitService.save(dogVisit);

        Owner fatih = new Owner();
        fatih.setFirstName("Fatih");
        fatih.setLastName("Sahin");
        fatih.setAddress("Bla Bla Bla");
        fatih.setCity("Istanbul");
        fatih.setTelephone("222-222-2222");

        Pet fatihsPet = new Pet();
        fatihsPet.setPetType(savedCatPetType);
        fatihsPet.setOwner(fatih);
        fatihsPet.setBirthDate(LocalDate.now());
        fatihsPet.setName("Pamuk");
        fatih.getPets().add(fatihsPet);


        ownerService.save(fatih);

        Visit catVisit = new Visit();
        catVisit.setPet(fatihsPet);
        catVisit.setDescription("Bla Bla");
        catVisit.setDate(LocalDate.now());

        visitService.save(catVisit);

        System.out.println("Loaded owners..");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(saveRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(saveDentistry);
        vet2.getSpecialties().add(saveSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets..");
    }
}
