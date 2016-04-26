package edu.nankai.cs.restaurant.repository;

import org.springframework.data.repository.CrudRepository;

import edu.nankai.cs.restaurant.entity.Order;

public interface OrderDao extends CrudRepository<Order, Long> {
}
