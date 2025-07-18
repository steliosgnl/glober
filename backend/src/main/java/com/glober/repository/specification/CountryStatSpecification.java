package com.glober.repository.specification;

import com.glober.model.Country;
import com.glober.model.CountryStat;
import com.glober.model.Region;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class CountryStatSpecification {

    public static Specification<CountryStat> hasRegion(Integer regionId) {
        
        if (regionId == null) {
            return null;
        }

        return (root, query, cb) -> {
            Join<CountryStat, Country> countryJoin = root.join("country");
            Join<Country, Region> regionJoin = countryJoin.join("region");
            return cb.equal(regionJoin.get("regionId"), regionId);
        };
    }

    public static Specification<CountryStat> isBetweenYears(Integer startYear, Integer endYear) {
        
        if (startYear == null && endYear == null) {
            return null;
        }

        if (startYear != null && endYear != null) {
            return (root, query, cb) -> cb.between(root.get("year"), startYear, endYear);
        }
        
        if (startYear != null) {
            return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("year"), startYear);
        }

        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("year"), endYear);
    }
}
