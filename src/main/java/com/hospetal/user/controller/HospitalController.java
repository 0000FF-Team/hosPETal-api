package com.hospetal.user.controller;


import com.hospetal.user.dto.response.HospitalListDto;
import com.hospetal.user.service.HospitalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/hospitals")
@RestController
public class HospitalController {
    private final HospitalService hospitalService;

    @GetMapping
    public List<HospitalListDto> list() {
        return hospitalService.getHospitals();
    }
}
