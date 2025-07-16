package com.glober.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "country_stats")
@IdClass(CountryStatId.class)
public class CountryStat {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Id
    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "population")
    private Integer population;

    @Column(name = "gdp", precision = 15, scale = 0)
    private BigDecimal gdp;
}