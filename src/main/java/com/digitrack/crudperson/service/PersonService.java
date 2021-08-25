package com.digitrack.crudperson.service;

import com.digitrack.crudperson.entities.Person;
import com.digitrack.crudperson.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class PersonService implements IPersonService{

    @Autowired
    private PersonRepository personRepository;

    /*Create person*/

    @Override
    public Person savePerson(Person person) {
      return personRepository.save(person);
    }

    /*Delete person*/
    @Override
    public boolean deletePerson(Long id) {
        boolean deleted = false;
        if (personRepository.findById(id).isPresent()) {
            personRepository.deleteById(id);
            deleted = true ;
        }
        return deleted;
    }

/*    @Override
    public List<Person> findAllPerson(){
        return personRepository.findAll();
    }*/

    @Override
    public String  updatePerson (Person personUpdated) {
        if (personRepository.findById(personUpdated.id).isPresent()) {
            personRepository.save(personUpdated);
            return "Person Updated";
        }
        return "Error Updated Person";
    }

    @Override
    public List<Person> findAllPerson() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person  findPersonById (Long id) {
      return personRepository.findById(id).get();

    }

    @Override
    public Page<Person> getAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }
}
