package com.fleet.demo.controller;

import com.fleet.demo.entity.DeliveryTask;
import com.fleet.demo.repository.DeliveryTaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class DeliveryTaskController {

    private final DeliveryTaskRepository repository;

    public DeliveryTaskController(DeliveryTaskRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public DeliveryTask addTask(@RequestBody DeliveryTask task) {
        return repository.save(task);
    }

    @GetMapping
    public List<DeliveryTask> getTasks() {
        return repository.findAll();
    }
}