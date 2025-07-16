package com.glober.model;

import java.io.Serializable;
import java.util.Objects;

public class CountryLanguageId implements Serializable {
    private int country;
    private int language;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryLanguageId)) return false;
        CountryLanguageId that = (CountryLanguageId) o;
        return country == that.country && language == that.language;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, language);
    }
}