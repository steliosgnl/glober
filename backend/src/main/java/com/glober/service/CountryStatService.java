package com.glober.service;

import com.glober.dto.MaxGdpStatDto;
import com.glober.repository.CountryStatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryStatService {

    private final CountryStatRepository countryStatRepository;

    public List<MaxGdpStatDto> getMaxGdpPerPopulationStats() {
        return countryStatRepository.findMaxGdpPerPopulationStats();
    }
}