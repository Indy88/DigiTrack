package com.digitrack.crudperson.controllers;

import com.digitrack.crudperson.entities.Person;
import com.digitrack.crudperson.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
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
    public ResponseEntity<List<Person>> getPersons() {
        return ResponseEntity.ok().body(personService.findAllPerson());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
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

 /*   @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        Map<String, String> map = new HashMap<>(errors.size());
        errors.forEach((error) -> {
            String key = ((FieldError) error).getField();
            String val = error.getDefaultMessage();
            map.put(key, val);
        });
        return ResponseEntity.badRequest().body(map);
    }*/

}
