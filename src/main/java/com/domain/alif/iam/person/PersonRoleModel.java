package com.domain.alif.iam.person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "person_role")
@Entity
public class PersonRoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "person_role_id", unique = true, nullable = true)
    private String personRoleId;


    @Column(name = "person_role_name", unique = true, nullable = true)
    private String personRoleName;

    @Column(name = "person_role_description", nullable = true)
    private String personRoleDescription;
}
