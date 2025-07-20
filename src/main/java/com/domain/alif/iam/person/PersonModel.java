package com.domain.alif.iam.person;

import com.domain.alif.iam.AuditMetadata;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "person")
public class PersonModel extends AuditMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String pwd;

    @Column(name = "phone", unique = true, nullable = true)
    private String phone;

    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "blood_group", nullable = true)
    private String bloodGroup;

    @ManyToOne(optional = true, targetEntity = AddressModel.class)
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = true)
    private AddressModel addressModel;

    @ManyToOne(fetch = FetchType.EAGER, optional = true) // removed cascade
    @JoinColumn(name = "person_role_id", referencedColumnName = "id", nullable = true)
    private PersonRoleModel personRoleModel;

}