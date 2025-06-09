package com.nuevaeps.msvc_request_medicine.domain.rules;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaginatorRule {

    public Pageable getPageable(Integer cantRecords, Integer pagCurrent) {
        return PageRequest.of(
                (pagCurrent == null) ? 0 : pagCurrent,
                (cantRecords == null) ? 15 : cantRecords
        );
    }
}
