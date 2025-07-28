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
    private String tag;

    @Column(name = "item_package")
    private String itemPackage;

    @Column(name = "desk_id")
    private String deskId;

    @Column(name = "office_space")
    private String officeSpace;

    @Column(name = "cabinet_number")
    private String cabinetNumber;

    @Column(name = "responsible_name")
    private String responsibleName;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_ref_id")
    private String refId;

    @Column(name = "item_category")
    private String category;

    @Column(name = "item_group")
    private String group;

    @Column(name = "item_remark")
    private String remark;
}
