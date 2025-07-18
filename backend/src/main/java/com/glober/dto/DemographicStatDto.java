package com.glober.dto;

import java.math.BigDecimal;

public record DemographicStatDto(
    String continentName,
    String regionName,
    String countryName,
    int year,
    Integer population,
    BigDecimal gdp
) {}