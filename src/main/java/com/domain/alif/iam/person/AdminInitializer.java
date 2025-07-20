package com.domain.alif.iam.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class AdminInitializer {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonRoleRepository personRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initAdminUser() {
        // Ensure ADMIN role exists
        PersonRoleModel adminRole = createRoleIfNotFound("ADMIN", "System Administrator");
        PersonRoleModel operatorRole = createRoleIfNotFound("OPERATOR", "System Operator");

        // Check if admin user exists
        PersonModel admin = personRepository.readByEmail("admin1@gmail.com");
        if (admin == null) {
            PersonModel newAdmin = new PersonModel();
            newAdmin.setEmail("admin1@gmail.com");
            newAdmin.setPwd("admin");
            newAdmin.setFirstName("System");
            newAdmin.setLastName("Admin");
            newAdmin.setPersonRoleModel(adminRole);
            personRepository.save(newAdmin);
        }
        PersonModel operator = personRepository.readByEmail("operator@gmail.com");
        if (operator == null) {
            PersonModel newOperator = new PersonModel();
            newOperator.setEmail("operator@gmail.com");
            newOperator.setPwd(passwordEncoder.encode("operator")); // encode password
            newOperator.setFirstName("System");
            newOperator.setLastName("Operator");
            newOperator.setPersonRoleModel(operatorRole);
            personRepository.save(newOperator);
        }
    }

    private PersonRoleModel createRoleIfNotFound(String name, String description) {
        PersonRoleModel role = personRoleRepository.findByPersonRoleName(name);
        if (role == null) {
            role = new PersonRoleModel();
            role.setPersonRoleName(name);
            role.setPersonRoleDescription(description);
            personRoleRepository.save(role);
        }
        return role;
    }
}
