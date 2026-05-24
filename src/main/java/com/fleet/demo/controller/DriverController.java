package com.fleet.demo.controller;

import com.fleet.demo.entity.Driver;
import com.fleet.demo.repository.DriverRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverRepository driverRepository;

    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @PostMapping
    public Driver addDriver(@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }

    @GetMapping
    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }
}