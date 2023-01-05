package com.hospetal.user.service;

import com.hospetal.user.dto.response.HospitalListDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class HospitalServiceTest {
    private HospitalService hospitalService;

    @BeforeEach
    void setUp() {
        hospitalService = new HospitalService();
    }

    @Test
    void getHospitals() {
        List<HospitalListDto> hospitals = hospitalService.getHospitals();
        Assertions.assertThat(hospitals).hasSize(1);
        Assertions.assertThat(hospitals.get(0).getName()).isEqualTo("블루동물병원");
    }
}