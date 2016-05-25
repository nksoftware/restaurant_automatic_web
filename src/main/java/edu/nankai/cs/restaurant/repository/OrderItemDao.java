package edu.nankai.cs.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.nankai.cs.restaurant.entity.OrderItem;

public interface OrderItemDao extends CrudRepository<OrderItem, OrderItem.PK> {
	
	@Query("select item from OrderItem item where item.status = \'preparing\'")
	List<OrderItem> findByStatusIsPreparing();
	
	@Query("select item from OrderItem item where item.status = \'cooking\'")
	List<OrderItem> findByStatusIsCooking();
}
