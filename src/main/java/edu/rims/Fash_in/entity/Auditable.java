package edu.rims.Fash_in.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public class Auditable {

    @Column(name = "created_at", updatable = false)
    private Timestamp createdDate;

    @Column(name = "updated_at", nullable = false)
    private Timestamp UpdatedDate;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;
    
}