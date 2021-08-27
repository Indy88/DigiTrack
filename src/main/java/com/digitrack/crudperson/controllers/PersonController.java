package com.digitrack.crudperson.controllers;

import com.digitrack.crudperson.entities.Person;
import com.digitrack.crudperson.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService service) {
        this.personService = service;
    }


    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return ResponseEntity.ok().body(personService.savePerson(person));
    }


    @GetMapping
    public ResponseEntity<Page<Person>> getAllPersons( @RequestParam (defaultValue = "0")int page,
                                                       @RequestParam (defaultValue = "10" )int size, //register per page
                                                       @RequestParam (defaultValue = "fullname" ) String order,
                                                       @RequestParam (defaultValue = "true" )boolean asc

    ) {
        Page <Person> personPage = personService.getAll( PageRequest.of(page, size, Sort.by(order)));
                if (!asc)
            personPage = personService.getAll( PageRequest.of(page, size, Sort.by(order).descending())
        );

     return new ResponseEntity<Page<Person>>(personPage,HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok().body("Person deleted");
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        return ResponseEntity.ok().body(personService.updatePerson(person));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable Long id){
        Optional<Person> person = personService.findPersonById(id);
        if (person.isPresent()){
            return ResponseEntity.ok().body(person.get());
        }
        return ResponseEntity.notFound().build();
    }


}
