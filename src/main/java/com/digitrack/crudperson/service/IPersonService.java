package com.digitrack.crudperson.service;

import com.digitrack.crudperson.entities.Person;

import java.util.List;

public interface IPersonService {

    Person savePerson(Person person);
    String updatePerson (Person personUpdated);
    List<Person> findAllPerson();
    String deletePerson(Long id);


}
