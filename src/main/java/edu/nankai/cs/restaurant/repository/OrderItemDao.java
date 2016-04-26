package edu.nankai.cs.restaurant.repository;

import org.springframework.data.repository.CrudRepository;

import edu.nankai.cs.restaurant.entity.OrderItem;

public interface OrderItemDao extends CrudRepository<OrderItem, OrderItem.PK> {
}
