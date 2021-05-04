package com.mucahit.petclinic.petclinic.services.map;

import com.mucahit.petclinic.petclinic.model.Specialty;
import com.mucahit.petclinic.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"map","default"})
public class SpecialityServiceMap extends AbstractMapService<Specialty, Long> implements SpecialityService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
