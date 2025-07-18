package com.glober.dto;

import java.math.BigDecimal;

public record MaxGdpStatDto(
    String countryName,
    String countryCode3,
    int year,
    Integer population,
    BigDecimal gdp
) {}
