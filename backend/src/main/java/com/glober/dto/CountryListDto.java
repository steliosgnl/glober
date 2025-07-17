package com.glober.dto;

import java.math.BigDecimal;

public record CountryListDto(
    int countryId,
    String name,
    BigDecimal area,
    String countryCode2
) {}