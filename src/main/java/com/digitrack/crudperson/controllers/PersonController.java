package com.digitrack.crudperson.controllers;

import com.digitrack.crudperson.entities.Person;
import com.digitrack.crudperson.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/v1/person")
@CrossOrigin(origins = "*")
public class PersonController {

   @Autowired
    PersonService personService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Person addPerson(@RequestBody Person person) {
     return personService.savePerson(person);
    }

    @GetMapping (value = "/allPerson")
    public List<Person> getPersons() {
        return personService.findAllPerson();
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deletePerson(@PathVariable Long id)
    {
        personService.deletePerson(id);
        return ResponseEntity.ok(id).toString();
    }


/*

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        ResponseEntity.ok("Person deleted sucessfully.");
        boolean deleted = personService.deletePerson(id);
        if(deleted)
            return ResponseEntity.ok("Person deleted successfully.");
        else return ResponseEntity.badRequest().body("Error! Person Not Found");
    }
*/


    @PutMapping(value = "/update")
    public String updatePerson(@PathVariable Person person) {
        return personService.updatePerson(person);
    }

    @GetMapping(value = "/findById/{id}")
    public Person findPersonById(@PathVariable Long id){
      return personService.findPersonById(id);
    }


    public String findAll(@RequestParam Map<String, Object>params, Model model){
        int page = params.get("page") != null? Integer.valueOf(params.get("page").toString()) - 1: 0;

        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Person> pagePersona = personService.getAll(pageRequest);

        int totalPage = pagePersona.getTotalPages();
        if (totalPage > 0){
            List<Integer>pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList()); //para que se cree un stream de numeros
        }
        model.addAttribute("list", pagePersona.getContent());
        return  "inex";

    }

}
