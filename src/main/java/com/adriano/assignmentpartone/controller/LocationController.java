package com.adriano.assignmentpartone.controller;

import com.adriano.assignmentpartone.domain.entity.Location;
import com.adriano.assignmentpartone.domain.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/location")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;


    @GetMapping
    public List<Location> listAll() {
        return locationRepository.findAll();
    }
    @PostMapping
    public Location save(@RequestBody Location location) {
        return locationRepository.save(location);
    }
}
