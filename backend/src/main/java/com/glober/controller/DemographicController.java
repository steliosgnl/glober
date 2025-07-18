package com.glober.controller;

import com.glober.dto.DemographicStatDto;
import com.glober.dto.RegionDto;
import com.glober.service.DemographicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demographics")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DemographicController {

    private final DemographicService demographicService;

    @GetMapping("/regions")
    public ResponseEntity<List<RegionDto>> getAllRegions() {
        return ResponseEntity.ok(demographicService.getAllRegions());
    }

    @GetMapping("/stats")
    public ResponseEntity<Page<DemographicStatDto>> getStats(
        @RequestParam(required = false) Integer regionId,
        @RequestParam(required = false) Integer startYear,
        @RequestParam(required = false) Integer endYear,
        Pageable pageable) {
        return ResponseEntity.ok(demographicService.getDemographicStats(regionId, startYear, endYear, pageable));
    }
}