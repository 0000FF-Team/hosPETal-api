package com.hospetal.user.controller;

import com.hospetal.user.dto.response.HospitalListDto;
import com.hospetal.user.service.HospitalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

@WebMvcTest(HospitalController.class)
class HospitalControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HospitalService hospitalService;

    @Test
    @DisplayName("GET /hospitals 요청 시 병원 목록이 리턴된다")
    void list() throws Exception {
        BDDMockito.given(hospitalService.getHospitals()).willReturn(getHospitalListDtos());
        mockMvc.perform(MockMvcRequestBuilders.get("/hospitals"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value("3"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("그린동물병원"))
                .andDo(MockMvcResultHandlers.print());
        BDDMockito.verify(hospitalService).getHospitals();
    }

    private static List<HospitalListDto> getHospitalListDtos() {
        HospitalListDto hospital = HospitalListDto.builder()
                .id(3L)
                .name("그린동물병원")
                .build();
        return Collections.singletonList(hospital);
    }
}