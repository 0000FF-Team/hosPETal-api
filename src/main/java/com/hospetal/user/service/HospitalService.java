package com.hospetal.user.service;

import com.hospetal.user.dto.response.HospitalListDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;


@Slf4j
@Service
public class HospitalService {
    public List<HospitalListDto> getHospitals() {
        HospitalListDto hospital = HospitalListDto.builder()
                .id(1L)
                .name("블루동물병원")
                .description("블루동물병원입니다.")
                .contactNumber("0329997777")
                .latitude(BigDecimal.valueOf(37.548379))
                .longitude(BigDecimal.valueOf(126.741047))
                .build();
        return Collections.singletonList(hospital);
    }
}
