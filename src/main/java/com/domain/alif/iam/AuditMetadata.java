package com.domain.alif.iam;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class AuditMetadata {

    @CreatedBy
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @CreatedDate
    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "status")
    private String status;

    // Getters and setters
    // Removed unused applyAuditCreate method

}
