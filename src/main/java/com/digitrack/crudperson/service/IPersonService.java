package com.digitrack.crudperson.service;

import com.digitrack.crudperson.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IPersonService {

    Person savePerson(Person person);
    Person updatePerson (Person personUpdated);
    String deletePerson(Long id);
    Optional<Person> findPersonById(Long id);

    Page<Person> getAll (Pageable pageable);
    Page<Person> findAllPerson (Pageable pageable, String searchText);

    Page<Person> findBySex(Pageable pageable, @Param("sex") boolean sex);
    Page<Person> findByDatebirth(Pageable pageable, @Param("datebirth") Date datebirth);



}
