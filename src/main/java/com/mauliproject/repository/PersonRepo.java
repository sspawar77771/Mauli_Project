package com.mauliproject.repository;

import com.mauliproject.entitites.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<PersonEntity,Integer> {

}
