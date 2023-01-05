package com.hospetal.user.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequestMapping("/hospitals")
@RestController
public class HospitalController {
    @GetMapping
    public String list() {
        return "Hello hosPETal User";
    }
}
