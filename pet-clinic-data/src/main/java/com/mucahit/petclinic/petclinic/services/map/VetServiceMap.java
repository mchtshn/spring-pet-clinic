package com.mucahit.petclinic.petclinic.services.map;

import com.mucahit.petclinic.petclinic.model.Specialty;
import com.mucahit.petclinic.petclinic.model.Vet;
import com.mucahit.petclinic.petclinic.services.SpecialityService;
import com.mucahit.petclinic.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet save(Vet vet) {
        if (vet.getSpecialties().size()>0){
            vet.getSpecialties().forEach(specialty -> {
                if (specialty.getId() ==null){
                    Specialty savedSpecialty = specialityService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
