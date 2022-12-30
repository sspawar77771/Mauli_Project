package com.mauliproject.controller;

import com.mauliproject.payload.PersonDto;
import com.mauliproject.repository.PersonRepo;
import com.mauliproject.service.PersonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepo personRepo;

    @PostMapping(value = "/create/person")
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto){
        PersonDto person = this.personService.createPerson(personDto);

        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("/update/person/{personId}")
    public ResponseEntity<PersonDto> updatePerson(@RequestBody PersonDto personDto,@PathVariable Integer personId){
        PersonDto personDto1 = this.personService.updatePerson(personDto, personId);

        return new ResponseEntity<>(personDto1,HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<PersonDto> getPersonById(@Valid @PathVariable Integer personId){
        PersonDto personById = this.personService.getPersonById(personId);

        return new ResponseEntity<>(personById,HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<PersonDto>> getAllPersons(){
        List<PersonDto> allPersons = this.personService.getAllPersons();

        return new ResponseEntity<>(allPersons,HttpStatus.OK);

    }
}
