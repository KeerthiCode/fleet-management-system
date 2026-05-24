package com.fleet.demo.controller;

import com.fleet.demo.entity.Vehicle;
import com.fleet.demo.repository.VehicleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id,
                                 @RequestBody Vehicle updatedVehicle) {

        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow();

        vehicle.setVehicleNumber(updatedVehicle.getVehicleNumber());
        vehicle.setModel(updatedVehicle.getModel());
        vehicle.setType(updatedVehicle.getType());
        vehicle.setStatus(updatedVehicle.getStatus());

        return vehicleRepository.save(vehicle);
    }

    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Long id) {

        vehicleRepository.deleteById(id);

        return "Vehicle deleted successfully";
    }
}