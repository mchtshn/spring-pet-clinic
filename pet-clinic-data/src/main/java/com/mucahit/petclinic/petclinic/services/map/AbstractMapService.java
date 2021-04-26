package com.mucahit.petclinic.petclinic.services.map;

import com.mucahit.petclinic.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {

        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);

        } else {
            throw new RuntimeException("Object can not be null");
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        Long nextID;
        try {
            nextID = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextID = 1L;
        }
        return nextID;
    }
}
