package com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name ="Tab_request_medicine")
public class RequestMedicineEntity {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "requestMedicineId")
    private int requestMedicineId;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medicineId")
    private MedicineEntity medicine;

    @OneToOne(mappedBy = "requestMedicine", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private DataAdditionsRequestEntity dataAdditionsRequest;

    @Column(name = "createdAt", nullable = false, updatable = false)
    @CreationTimestamp
    private java.sql.Timestamp createdAt;

    @Column(name = "updatedAt", nullable = false)
    @UpdateTimestamp
    private java.sql.Timestamp updatedAt;
}
