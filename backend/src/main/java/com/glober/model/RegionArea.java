package com.glober.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "region_areas")
public class RegionArea {

    @Id
    @Column(name = "region_name", length = 100)
    private String regionName;

    @Column(name = "region_area", nullable = false, precision = 15, scale = 2)
    private BigDecimal regionArea;
}