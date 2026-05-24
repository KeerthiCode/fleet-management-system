package com.fleet.demo.repository;

import com.fleet.demo.entity.DeliveryTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryTaskRepository extends JpaRepository<DeliveryTask, Long> {
}