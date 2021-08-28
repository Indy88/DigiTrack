package com.digitrack.crudperson.service;

import com.digitrack.crudperson.entities.Person;
import com.digitrack.crudperson.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService{

    @Autowired
    private PersonRepository personRepository;

    /*Create person*/

    @Override
    public Person savePerson(Person person) {
        if (person != null) {
            return personRepository.save(person);
        }
        return new Person();
    }

    @Override
    public Person updatePerson (Person personUpdated) {
        if (personRepository.findById(personUpdated.id).isPresent()) {
            return personRepository.save(personUpdated);
        }
        return new Person();
    }

    /*Delete person*/
    @Override
    public String deletePerson(Long id) {
        if (personRepository.findById(id).isPresent()) {
            personRepository.deleteById(id);
            return "Person deleted successfully.";
        }
        return "Error! Person Not Found";
    }



    @Override
    public Optional<Person> findPersonById (Long id) {
      return personRepository.findById(id);

    }

    @Override
    public Page<Person> getAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }


    @Override
    public Page<Person> findAllPerson (Pageable pageable, String searchText){
        return personRepository.findAllPerson(pageable, searchText);
    }

    @Override
    public Page<Person> findBySex (Pageable pageable, boolean gender){
        return personRepository.findBySex(pageable, gender);
    }

    @Override
    public Page<Person> findByDatebirth (Pageable pageable, Date date){
        return personRepository.findByDatebirth(pageable, date);
    }

}
