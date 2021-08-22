package com.digitrack.crudperson.repository;

import com.digitrack.crudperson.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository  extends CrudRepository<Person, Long> {

}

