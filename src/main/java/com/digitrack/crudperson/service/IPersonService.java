package com.digitrack.crudperson.service;

import com.digitrack.crudperson.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IPersonService {

    Person savePerson(Person person);
    Person updatePerson (Person personUpdated);
    List<Person> findAllPerson();
    String deletePerson(Long id);
    Optional<Person> findPersonById(Long id);

    Page<Person> getAll (Pageable pageable);


}
