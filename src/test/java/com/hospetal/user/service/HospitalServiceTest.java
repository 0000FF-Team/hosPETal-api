package com.hospetal.user.service;

import com.hospetal.user.domain.entity.Hospital;
import com.hospetal.user.domain.repository.HospitalRepository;
import com.hospetal.user.dto.response.HospitalListDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class HospitalServiceTest {
    private HospitalService hospitalService;
    @Mock
    private HospitalRepository hospitalRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        hospitalService = new HospitalService(hospitalRepository);
    }

    @AfterEach
    void teardown() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }

    @Test
    @DisplayName("병원 목록 조회")
    void getHospitals() {
        // given
        BDDMockito.given(hospitalRepository.findAll()).willReturn(generateHospitals());

        // when
        List<HospitalListDto> dtos = hospitalService.getHospitals();

        // then
        Assertions.assertThat(dtos).hasSize(1);

        HospitalListDto hospital = dtos.get(0);
        Assertions.assertThat(hospital.getName()).isEqualTo("그레이동물병원");
        Assertions.assertThat(hospital.getId()).isEqualTo(33L);

        BDDMockito.verify(hospitalRepository).findAll();
    }

    private static List<Hospital> generateHospitals() {
        List<Hospital> hospitals = new ArrayList<>();
        hospitals.add(Hospital.builder()
                .id(33L)
                .name("그레이동물병원")
                .description("그레이동물병원입니다.")
                .contactNumber("0329997777")
                .latitude(BigDecimal.valueOf(37.548379))
                .longitude(BigDecimal.valueOf(126.741047))
                .build());
        return hospitals;
    }
}