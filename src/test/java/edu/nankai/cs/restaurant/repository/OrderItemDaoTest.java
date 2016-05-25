package edu.nankai.cs.restaurant.repository;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import edu.nankai.cs.restaurant.entity.Menu;
import edu.nankai.cs.restaurant.entity.Order;
import edu.nankai.cs.restaurant.entity.OrderItem;

@ContextConfiguration("/applicationContext.xml")
public class OrderItemDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private MenuDao menuDao;
	
	@Test
	@Rollback(false)
	public void addOrderItem(){
		Order order = orderDao.findOne(300L);
		Menu menu = menuDao.findOne(150L);
		
		OrderItem orderItem = new OrderItem();
		orderItem.setEachPayment(100);
		orderItem.setQuantity(2);
		orderItem.setStatus("ordering");
		orderItem.setPk(new OrderItem.PK(order,menu));
		
		orderItemDao.save(orderItem);
	}
	
	@Test
	public void getUnfinished(){
		List<OrderItem> orderItems = orderItemDao.findByStatusIsPreparing();
		System.out.println(orderItems.size());
	}
	
	@Test
	public void getCooking(){
		List<OrderItem> orderItems = orderItemDao.findByStatusIsCooking();
		System.out.println(orderItems.size());
	}
	
}
