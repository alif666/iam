package com.domain.alif.iam.device;

import com.domain.alif.iam.AuditMetadata;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "device_list")
public class DeviceList extends AuditMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String team;

    @Column(name = "item_tag")
    private String itemTag;

    @Column(name = "item_package")
    private String itemPackage;

    @Column(name = "item_responsible_id")
    private String itemResponsibleId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_ref_id")
    private String itemRefId;

    @Column(name = "item_category")
    private String itemCategory;

    @Column(name = "item_group")
    private String itemGroup;

    @Column(name = "item_brand")
    private String itemBrand;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "item_remark")
    private String itemRemark;
}

