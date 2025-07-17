package com.glober.repository;

import com.glober.dto.CountryListDto;
import com.glober.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query("SELECT new com.glober.dto.CountryListDto(c.countryId, c.name, c.area, c.countryCode2) FROM Country c " + 
            "ORDER BY c.name")
    List<CountryListDto> findAllCountries();
}
