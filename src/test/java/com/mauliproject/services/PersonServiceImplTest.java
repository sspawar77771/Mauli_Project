package com.mauliproject.services;

import com.mauliproject.entitites.PersonEntity;
import com.mauliproject.payload.PersonDto;
import com.mauliproject.repository.PersonRepo;
import com.mauliproject.serviceImpl.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PersonServiceImplTest {

    @InjectMocks
    PersonServiceImpl personService;

    @Mock
    PersonRepo personRepo;

    @Mock
    ModelMapper modelMapper;

    PersonEntity personEntity;
    PersonDto personDto;

    List<PersonEntity> personEntityList;

    List<PersonDto> personDtoList;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);

        personEntity = new PersonEntity();
        personEntity.setPersonId(12);
        personEntity.setEmail("mail@mail.com");
        personEntity.setFullName("Amol");
        personEntity.setFullAddress("address");
        personEntity.setDonationAmount(123);
        personEntity.setMobile_no(919764237376L);
        personEntity.setCreatedDateAndTime(LocalDateTime.now());
        personEntity.setUpdatedDateAndTime(LocalDateTime.now());

        personEntityList = new ArrayList<>();
        personEntityList.add(personEntity);

        personDto = new PersonDto();
        personDto.setPersonId(12);
        personDto.setEmail("mail@mail.com");
        personDto.setFullName("Amol");
        personDto.setFullAddress("address");
        personDto.setDonationAmount(123);
        personDto.setMobile_no(919764237376L);
        personDto.setCreatedDateAndTime(LocalDateTime.now());
        personDto.setUpdatedDateAndTime(LocalDateTime.now());

        personDtoList = new ArrayList<>();
        personDtoList.add(personDto);
    }

    @Test
    public void createPersonTest_success(){
        when(personRepo.save(personEntity)).thenReturn(personEntity);
        when(modelMapper.map(personDto, PersonEntity.class)).thenReturn(personEntity);
        when(modelMapper.map(personEntity, PersonDto.class)).thenReturn(personDto);
        PersonDto personDto1 = personService.createPerson(personDto);
        assertEquals(personEntity.getEmail(), personDto1.getEmail());
        assertNotNull(personDto1);
    }

    @Test
    public void updatePersonTest_success(){
        when(personRepo.findById(12)).thenReturn(Optional.of(personEntity));
        when(modelMapper.map(personEntity, PersonDto.class)).thenReturn(personDto);
        PersonDto personDto1 = personService.updatePerson(personDto, 12);
        assertEquals(personEntity.getEmail(), personDto1.getEmail());
        assertNotNull(personDto1);
    }

    @Test
    public void getPersonByIdTest_success(){
        when(personRepo.findById(12)).thenReturn(Optional.of(personEntity));
        when(modelMapper.map(personEntity, PersonDto.class)).thenReturn(personDto);
        PersonDto personDto1 = personService.getPersonById(12);
        assertEquals(12, personDto1.getPersonId());
        assertNotNull(personDto1);
    }

    @Test
    public void getAllPersonsTest_success(){
        when(personRepo.findAll()).thenReturn(personEntityList);
        List<PersonDto> personDtoList1 = personService.getAllPersons();
        assertNotNull(personDtoList1);
    }

    @Test
    public void deletePersonTest_success(){
        when(personRepo.findById(12)).thenReturn(Optional.of(personEntity));
        personService.deletePerson(12);
    }

}
