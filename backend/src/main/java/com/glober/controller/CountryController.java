package com.glober.controller;

import com.glober.dto.CountryListDto;
import com.glober.dto.CountryNameDto;
import com.glober.dto.LanguageDto;
import com.glober.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryListDto>> getAllCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @GetMapping("/{id}/languages")
    public ResponseEntity<List<LanguageDto>> getLanguagesForCountry(@PathVariable int id) {
        return ResponseEntity.ok(countryService.getLanguagesByCountryId(id));
    }

    @GetMapping("/{id}/name")
    public ResponseEntity<CountryNameDto> getCountryName(@PathVariable int id) {
        return ResponseEntity.ok(countryService.getCountryNameById(id));
    }
}