package com.glober.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "area", nullable = false, precision = 10, scale = 2)
    private BigDecimal area;

    @Column(name = "national_day")
    private LocalDate nationalDay;

    @Column(name = "country_code2", nullable = false, length = 2, unique = true)
    private String countryCode2;

    @Column(name = "country_code3", nullable = false, length = 3, unique = true)
    private String countryCode3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;
}
