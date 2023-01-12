package com.hospetal.user.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class HospitalDetailDto {
    private Long id;
    private String name;
    private String description;
    private String contactNumber;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
