package com.hospetal.user.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String contactNumber;
    private BigDecimal latitude;
    private BigDecimal longitude;

    @Builder
    public Hospital(Long id, String name, String description, String contactNumber, BigDecimal latitude, BigDecimal longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.contactNumber = contactNumber;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
