package com.mucahit.petclinic.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;
}
