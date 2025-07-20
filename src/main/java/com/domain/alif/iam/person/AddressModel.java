package com.domain.alif.iam.person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private String city;
    private String district;

    @Column(name = "district_code")
    private String districtCode;

    @Column(name = "post_office")
    private String postOffice;
    private String division;

    @Column(name = "country_code")
    private String countryCode;
    private String state;

    @Column(name = "zip_code")
    private String zipCode;
    private String country;
}
