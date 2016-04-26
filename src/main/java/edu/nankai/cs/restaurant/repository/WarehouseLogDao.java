package edu.nankai.cs.restaurant.repository;

import org.springframework.data.repository.CrudRepository;

import edu.nankai.cs.restaurant.entity.WarehouseLog;

public interface WarehouseLogDao extends CrudRepository<WarehouseLog, Long> {
}
