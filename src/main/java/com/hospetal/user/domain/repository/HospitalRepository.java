package com.hospetal.user.domain.repository;

import com.hospetal.user.domain.entity.Hospital;

import java.util.List;

public interface HospitalRepository {
    List<Hospital> findAll();
}
