package com.hospetal.user.domain.repository;

import com.hospetal.user.domain.entity.Hospital;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryHospitalRepository implements HospitalRepository {
    private List<Hospital> hospitals = new ArrayList<>();

    @Override
    public List<Hospital> findAll() {
        hospitals.add(Hospital.builder()
                .id(2L)
                .name("블루동물병원")
                .description("블루동물병원입니다.")
                .contactNumber("0329997777")
                .latitude(BigDecimal.valueOf(37.548379))
                .longitude(BigDecimal.valueOf(126.741047))
                .build());
        return hospitals;
    }
}
