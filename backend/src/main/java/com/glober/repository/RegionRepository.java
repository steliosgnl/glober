package com.glober.repository;

import com.glober.dto.RegionDto;
import com.glober.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    @Query("SELECT new com.glober.dto.RegionDto(r.regionId, r.name) FROM Region r ORDER BY r.name")
    List<RegionDto> findAllRegionsForDto();
}