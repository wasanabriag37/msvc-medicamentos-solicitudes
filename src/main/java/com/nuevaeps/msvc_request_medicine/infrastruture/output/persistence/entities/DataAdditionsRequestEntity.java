package com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.entities;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name ="Tab_data_add_request")
public class DataAdditionsRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dataAdditionsRequestId")
    private int dataAdditionsRequestId;

    @Column(name = "numberOrder")
    private Long numberOrder;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requestMedicineId", nullable = false)
    private RequestMedicineEntity requestMedicine;

    @Column(name = "createdAt", nullable = false, updatable = false)
    @CreationTimestamp
    private java.sql.Timestamp createdAt;

    @Column(name = "updatedAt", nullable = false)
    @UpdateTimestamp
    private java.sql.Timestamp updatedAt;


}
