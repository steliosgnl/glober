package com.glober.controller;

import com.glober.model.Continent;
import com.glober.service.ContinentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/continents")
@CrossOrigin // Allow CORS for frontend (Angular)
public class ContinentController {

    private final ContinentService continentService;

    public ContinentController(ContinentService continentService) {
        this.continentService = continentService;
    }

    @GetMapping
    public List<Continent> getAllContinents() {
        return continentService.getAllContinents();
    }
}