package com.glober.service;

import com.glober.dto.CountryListDto;
import com.glober.dto.LanguageDto;
import com.glober.repository.CountryLanguageRepository;
import com.glober.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryLanguageRepository countryLanguageRepository;

    public List<CountryListDto> getAllCountries() {
        return countryRepository.findAllCountries();
    }

    public List<LanguageDto> getLanguagesByCountryId(int countryId) {
        return countryLanguageRepository.findLanguagesByCountryId(countryId);
    }
}