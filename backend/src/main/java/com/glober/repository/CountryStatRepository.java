package com.glober.repository;

import com.glober.dto.MaxGdpStatDto;
import com.glober.model.CountryStat;
import com.glober.model.CountryStatId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryStatRepository extends JpaRepository<CountryStat, CountryStatId> {

    @Query("SELECT new com.glober.dto.MaxGdpStatDto(c.name, c.countryCode3, cs.year, cs.population, cs.gdp) " +
           "FROM CountryStat cs JOIN cs.country c " +
           "WHERE (cs.gdp / cs.population) = (" +
           "  SELECT MAX(cs2.gdp / cs2.population) " +
           "  FROM CountryStat cs2 " +
           "  WHERE cs2.country.countryId = c.countryId" +
           ")")
    List<MaxGdpStatDto> findMaxGdpPerPopulationStats();
}