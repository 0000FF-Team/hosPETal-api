package com.hospetal.user.service;

import com.hospetal.user.domain.entity.Hospital;
import com.hospetal.user.domain.repository.HospitalRepository;
import com.hospetal.user.dto.response.HospitalListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RequiredArgsConstructor
@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public List<HospitalListDto> getHospitals() {
        List<Hospital> hospitals = hospitalRepository.findAll();
        return hospitals.stream().map(HospitalService::toDto).collect(Collectors.toList());
    }

    private static HospitalListDto toDto(Hospital hospital) {
        return HospitalListDto.builder()
                .id(hospital.getId())
                .name(hospital.getName())
                .contactNumber(hospital.getContactNumber())
                .description(hospital.getDescription())
                .latitude(hospital.getLatitude())
                .longitude(hospital.getLongitude())
                .build();
    }
}
