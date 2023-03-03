package com.mauliproject.controllers;

import com.mauliproject.controller.PersonController;
import com.mauliproject.payload.PersonDto;
import com.mauliproject.repository.PersonRepo;
import com.mauliproject.serviceImpl.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class PersonControllerTest {

    @Mock
    PersonServiceImpl personService = new PersonServiceImpl();
    @Mock
    PersonRepo personRepo;

    @InjectMocks
    PersonController personController;

    PersonDto person;
    PersonDto person1;
    List<PersonDto> allPersons;

    @BeforeEach
    public void setup() {

        MockitoAnnotations.initMocks(this);

        person = new PersonDto();
        person.setPersonId(12);
        person.setEmail("mail@mail.com");
        person.setFullName("Amol");
        person.setFullAddress("address");
        person.setDonationAmount(123);
        person.setMobile_no(919764237376L);
        person.setCreatedDateAndTime(LocalDateTime.now());
        person.setUpdatedDateAndTime(LocalDateTime.now());

        person1 = new PersonDto();
        person1.setPersonId(13);
        person1.setEmail("mail1@mail.com");
        person1.setFullName("Amol1");
        person1.setFullAddress("address1");
        person1.setDonationAmount(124);
        person1.setMobile_no(919764237378L);
        person1.setCreatedDateAndTime(LocalDateTime.now());
        person1.setUpdatedDateAndTime(LocalDateTime.now());

        allPersons = new ArrayList<>();
        allPersons.add(person);
        allPersons.add(person1);

    }

    @Test
    public void getAllPersonsTest_success() {
        when(personService.getAllPersons()).thenReturn(allPersons);
        ResponseEntity<List<PersonDto>> getAllPersons = personController.getAllPersons();
        assertEquals(HttpStatus.OK, getAllPersons.getStatusCode());
        assertEquals(2, Objects.requireNonNull(getAllPersons.getBody()).size());
    }

    @Test
    public void getAllPersonsTest_whenDataIsZero() {
        allPersons = new ArrayList<>();
        when(personService.getAllPersons()).thenReturn(allPersons);
        ResponseEntity<List<PersonDto>> getAllPersons = personController.getAllPersons();
        assertEquals(HttpStatus.OK, getAllPersons.getStatusCode());
        assertEquals(0, Objects.requireNonNull(getAllPersons.getBody()).size());
    }

    @Test
    public void getPersonsByIdTest_success() {
        when(personService.getPersonById(12)).thenReturn(person);
        ResponseEntity<PersonDto> getPersonsById = personController.getPersonById(12);
        assertEquals(HttpStatus.OK, getPersonsById.getStatusCode());
        assertEquals(12, Objects.requireNonNull(getPersonsById.getBody()).getPersonId());
    }

    @Test
    public void getPersonsByIdTest_whenDataIsNull() {
        person = new PersonDto();
        when(personService.getPersonById(12)).thenReturn(person);
        ResponseEntity<PersonDto> getPersonsById = personController.getPersonById(12);
        assertEquals(HttpStatus.OK, getPersonsById.getStatusCode());
        assertNull(Objects.requireNonNull(getPersonsById.getBody()).getPersonId());
    }

    @Test
    public void createPerson_success() {
        when(personService.createPerson(person)).thenReturn(person);
        ResponseEntity<PersonDto> createPerson = personController.createPerson(person);
        assertEquals(HttpStatus.CREATED, createPerson.getStatusCode());
        assertEquals(person, createPerson.getBody());
    }

    @Test
    public void createPersonTest_whenDataIsNull() {
        person = new PersonDto();
        when(personService.createPerson(person)).thenReturn(person);
        ResponseEntity<PersonDto> createPerson = personController.createPerson(person);
        assertEquals(HttpStatus.CREATED, createPerson.getStatusCode());
        assertEquals(person, createPerson.getBody());
    }

    @Test
    public void updatePerson_success() {
        PersonDto updatedPerson = new PersonDto();
        updatedPerson.setEmail("mail11@mail.com");
        updatedPerson.setFullName("Amol11");
        when(personService.updatePerson(updatedPerson, 13)).thenReturn(updatedPerson);
        ResponseEntity<PersonDto> updatePerson = personController.updatePerson(updatedPerson, 13);
        assertEquals(HttpStatus.OK, updatePerson.getStatusCode());
        assertEquals(updatedPerson.getEmail(), Objects.requireNonNull(updatePerson.getBody()).getEmail());
        assertEquals(updatedPerson.getFullName(), Objects.requireNonNull(updatePerson.getBody()).getFullName());
    }

    @Test
    public void updatePersonTest_whenDataIsNull() {
        person1 = new PersonDto();
        when(personService.updatePerson(person1, 13)).thenReturn(person1);
        ResponseEntity<PersonDto> updatePerson = personController.updatePerson(person1, 13);
        assertEquals(HttpStatus.OK, updatePerson.getStatusCode());
        assertEquals(person1, updatePerson.getBody());
    }
}
