package com.glober.repository;

import com.glober.dto.LanguageDto;
import com.glober.model.CountryLanguage;
import com.glober.model.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {

    @Query("SELECT new com.glober.dto.LanguageDto(l.languageId, l.language) " +
            "FROM CountryLanguage cl " + 
            "JOIN cl.country c " +
            "JOIN cl.language l " +
            "WHERE c.countryId = :countryId")
    List<LanguageDto> findLanguagesByCountryId(@Param("countryId") int countryId);
}