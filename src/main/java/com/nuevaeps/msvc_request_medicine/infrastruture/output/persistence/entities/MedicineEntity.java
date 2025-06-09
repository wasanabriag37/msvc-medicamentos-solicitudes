package com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Tab_medicine")
public class MedicineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicineId")
    private int medicineId;

    @Column(name = "code")
    private Long code;

    @Column(name = "nameMedicine")
    private String nameMedicine;
    
    @Column(name = "coveragePos")
    private boolean coveragePos;

    @Column(name = "createdAt", nullable = false, updatable = false)
    @CreationTimestamp
    private java.sql.Timestamp createdAt;

    @Column(name = "updatedAt", nullable = false)
    @UpdateTimestamp
    private java.sql.Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "requestMedicineId", nullable = false)
    private RequestMedicineEntity requestMedicine;


}
