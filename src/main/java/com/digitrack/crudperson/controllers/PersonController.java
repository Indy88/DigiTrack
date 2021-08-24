package com.digitrack.crudperson.controllers;

import com.digitrack.crudperson.entities.Person;
import com.digitrack.crudperson.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@CrossOrigin(origins = "*")
public class PersonController {

   @Autowired
    PersonService personService;


    @PostMapping(value = "/add")
    public Person addPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping (value = "/allPerson")
    public List<Person> getPersons() {
        return personService.findAllPerson();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)

    public String deletePerson(@PathVariable Long id) {
        return personService.deletePerson(id);
    }

    @PutMapping(value = "/update")
    public String updatePerson(@PathVariable Person person) {
        return personService.updatePerson(person);
    }

    @GetMapping(value = "/findById/{id}")
    public Person findPersonById(@PathVariable Long id){
      return personService.findPersonById(id);
    }

}
