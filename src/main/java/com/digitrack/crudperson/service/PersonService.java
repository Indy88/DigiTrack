package com.digitrack.crudperson.service;

import com.digitrack.crudperson.entities.Person;
import com.digitrack.crudperson.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /*Delete person*/
    @Override
    public String deletePerson(Long id) {
        if (personRepository.findById(id).isPresent()) {
            personRepository.deleteById(id);
            return "Person deleted sucessfully.";
        }
        return "Error! Person Not Found";
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


}
