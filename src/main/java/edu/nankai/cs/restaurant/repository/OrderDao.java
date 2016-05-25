package edu.nankai.cs.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.nankai.cs.restaurant.entity.Order;

public interface OrderDao extends CrudRepository<Order, Long> {
	
	@Query("select o from Order o where o.status <> \'paid\' and o.table.tableId = ?1 order by o.orderId asc")
	List<Order> findOrderByStatusNotPaid(Long tableId);
	
}
