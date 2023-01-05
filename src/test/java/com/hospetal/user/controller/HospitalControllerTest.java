package com.hospetal.user.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HospitalController.class)
class HospitalControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void list() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hospitals"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello hosPETal User"))
                .andDo(MockMvcResultHandlers.print());
    }
}