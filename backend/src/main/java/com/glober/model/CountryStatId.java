package com.glober.model;

import java.io.Serializable;
import java.util.Objects;

public class CountryStatId implements Serializable {
    private int country;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryStatId)) return false;
        CountryStatId that = (CountryStatId) o;
        return country == that.country && year == that.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, year);
    }
}