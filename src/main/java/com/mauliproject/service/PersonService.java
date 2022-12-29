package com.mauliproject.service;

import com.mauliproject.payload.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto createPerson(PersonDto personDto);

    PersonDto updatePerson(PersonDto personDto,Integer personId);

    PersonDto getPersonById(Integer personId);

    List<PersonDto> getAllPersons();

    void deletePerson(Integer personId);
}
