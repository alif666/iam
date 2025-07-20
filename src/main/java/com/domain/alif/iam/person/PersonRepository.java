package com.domain.alif.iam.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {

    
    PersonModel readByEmail(String email);
    
}
