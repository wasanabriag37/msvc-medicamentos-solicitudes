package com.nuevaeps.msvc_request_medicine.infrastruture.input.models;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FilterRequestMedicine {
    private List<Integer> usersIds;
    private LocalDate creationDate;
    private String nameMedicine;
    private Long code;
    private Integer requestMedicineId;
    private Long numberOrder;
    private List<Integer> medicineIds;
    private Boolean coveragePos;
    private Integer pagCurrent;
    private Integer cantRecords;


}
