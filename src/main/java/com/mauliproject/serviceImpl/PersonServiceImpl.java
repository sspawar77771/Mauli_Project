package com.mauliproject.serviceImpl;

import com.mauliproject.entitites.PersonEntity;
import com.mauliproject.payload.PersonDto;
import com.mauliproject.repository.PersonRepo;
import com.mauliproject.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        PersonEntity person = this.modelMapper.map(personDto, PersonEntity.class);

        PersonEntity savedPerson = this.personRepo.save(person);

        PersonDto personDtoSaved = this.modelMapper.map(savedPerson, PersonDto.class);

        return personDtoSaved;
    }

    @Override
    public PersonDto updatePerson(PersonDto personDto, Integer personId) {
        PersonEntity personEntity = this.personRepo.findById(personId).orElseThrow(() -> new RuntimeException("Person with given Id not found"));

        personEntity.setFullName(personDto.getFullName());
        personEntity.setFullAddress(personDto.getFullAddress());
        personEntity.setEmail(personDto.getEmail());
        personEntity.setMobile_no(personDto.getMobile_no());
        personEntity.setDonationAmount(personDto.getDonationAmount());
        personEntity.setUpdatedDateAndTime(LocalDateTime.now());

        PersonDto updatedDto = this.modelMapper.map(personEntity, PersonDto.class);

        return updatedDto;
    }

    @Override
    public PersonDto getPersonById(Integer personId) {
        PersonEntity personEntity = this.personRepo.findById(personId).orElseThrow(() -> new RuntimeException("No person found with given Id"));

        PersonDto personFindById = this.modelMapper.map(personEntity, PersonDto.class);

        return personFindById;
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<PersonEntity> allpersons = this.personRepo.findAll();

        List<PersonDto> personDtos = new ArrayList<>();

        for (PersonEntity personEntity:allpersons) {
            PersonDto dto = this.modelMapper.map(personEntity, PersonDto.class);

            personDtos.add(dto);
        }
        return personDtos;
    }

    @Override
    public void deletePerson(Integer personId) {
        PersonEntity personEntity = this.personRepo.findById(personId).orElseThrow(() -> new RuntimeException("No person found with given Id"));

        this.personRepo.deleteById(personId);

        System.out.println("Person deleted successfully");
    }
}
