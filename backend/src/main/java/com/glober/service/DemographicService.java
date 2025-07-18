package com.glober.service;

import com.glober.dto.DemographicStatDto;
import com.glober.dto.RegionDto;
import com.glober.model.CountryStat;
import com.glober.repository.CountryStatRepository;
import com.glober.repository.RegionRepository;
import com.glober.repository.specification.CountryStatSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DemographicService {

    private final CountryStatRepository countryStatRepository;
    private final RegionRepository regionRepository;

    public List<RegionDto> getAllRegions() {
        return regionRepository.findAllRegionsForDto();
    }

    public Page<DemographicStatDto> getDemographicStats(Integer regionId, Integer startYear, Integer endYear, Pageable pageable) {
        
        // Applying filters for region and years
        Specification<CountryStat> spec = Specification
            .where(CountryStatSpecification.hasRegion(regionId))
            .and(CountryStatSpecification.isBetweenYears(startYear, endYear));

        Page<CountryStat> statsPage = countryStatRepository.findAll(spec, pageable);

        return statsPage.map(this::convertToDto);
    }

    private DemographicStatDto convertToDto(CountryStat stat) {
        return new DemographicStatDto(
            stat.getCountry().getRegion().getContinent().getName(),
            stat.getCountry().getRegion().getName(),
            stat.getCountry().getName(),
            stat.getYear(),
            stat.getPopulation(),
            stat.getGdp()
        );
    }
}