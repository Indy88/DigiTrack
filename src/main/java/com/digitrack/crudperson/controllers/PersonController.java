package com.digitrack.crudperson.controllers;

import com.digitrack.crudperson.entities.Person;
import com.digitrack.crudperson.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

   @Autowired
    PersonService personService;


    @PostMapping(value = "/add")
//    @RequestMapping(value = "/add",  method = RequestMethod.POST, produces = "application/json")
    public Person addPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }
   /* public Person addPerson(Person person) {
        return personService.savePerson(person);
    }*/


    @RequestMapping(value = "/allPerson", method = RequestMethod.GET,  produces = "application/json")

    public List<Person> getPersons() {
        return personService.findAllPerson();
    }

    @RequestMapping(value = "/person/delete/{id}", method = RequestMethod.GET, produces = "application/json")

    public String deletePerson(@PathVariable Long id) {
        return personService.deletePerson(id);
    }

    @RequestMapping(value = "/customers/update", method = RequestMethod.PATCH, produces = "application/json")

    public String updatePerson(Person person) {
        return personService.updatePerson(person);
    }

}
