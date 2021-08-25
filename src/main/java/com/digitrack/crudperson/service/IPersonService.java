package com.digitrack.crudperson.service;

import com.digitrack.crudperson.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPersonService {

    Person savePerson(Person person);
    String updatePerson (Person personUpdated);
    List<Person> findAllPerson();
    boolean  deletePerson(Long id);
    Person findPersonById(Long id);

    Page<Person> getAll (Pageable pageable);


}
