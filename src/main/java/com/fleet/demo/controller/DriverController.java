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

    @PutMapping("/{id}")
    public Driver updateDriver(@PathVariable Long id,
                               @RequestBody Driver updatedDriver) {

        Driver driver = driverRepository.findById(id).orElseThrow();

        driver.setName(updatedDriver.getName());
        driver.setLicenseNumber(updatedDriver.getLicenseNumber());
        driver.setPhone(updatedDriver.getPhone());

        return driverRepository.save(driver);
    }

    @DeleteMapping("/{id}")
    public String deleteDriver(@PathVariable Long id) {

        driverRepository.deleteById(id);

        return "Driver deleted successfully";
    }
}