package com.mauliproject.repository;

import com.mauliproject.entitites.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<PersonEntity,Integer> {

}
