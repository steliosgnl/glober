package com.glober.service;

import com.glober.model.Continent;
import com.glober.repository.ContinentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentService {

    private final ContinentRepository continentRepository;

    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    public List<Continent> getAllContinents() {
        return continentRepository.findAll();
    }
}