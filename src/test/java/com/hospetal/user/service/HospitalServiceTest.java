package com.hospetal.user.service;

import com.hospetal.user.domain.repository.HospitalRepository;
import com.hospetal.user.domain.repository.MemoryHospitalRepository;
import com.hospetal.user.dto.response.HospitalListDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class HospitalServiceTest {
    private HospitalService hospitalService;
    private HospitalRepository hospitalRepository;

    @BeforeEach
    void setUp() {
        hospitalRepository = new MemoryHospitalRepository();
        hospitalService = new HospitalService(hospitalRepository);
    }

    @Test
    void getHospitals() {
        List<HospitalListDto> hospitals = hospitalService.getHospitals();
        Assertions.assertThat(hospitals).hasSize(1);
        HospitalListDto hospital = hospitals.get(0);
        Assertions.assertThat(hospital.getName()).isEqualTo("블루동물병원");
        Assertions.assertThat(hospital.getId()).isEqualTo(2L);
    }
}