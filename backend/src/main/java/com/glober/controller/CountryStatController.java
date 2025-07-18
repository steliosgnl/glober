package com.glober.controller;

import com.glober.dto.MaxGdpStatDto;
import com.glober.service.CountryStatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CountryStatController {

    private final CountryStatService countryStatService;

    @GetMapping("/max-gdp-ratio")
    public ResponseEntity<List<MaxGdpStatDto>> getMaxGdpRatioStats() {
        return ResponseEntity.ok(countryStatService.getMaxGdpPerPopulationStats());
    }
}