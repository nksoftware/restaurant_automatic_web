package edu.nankai.cs.restaurant.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import edu.nankai.cs.restaurant.entity.Order;
import edu.nankai.cs.restaurant.entity.Table;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class OrderDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private TableDao tableDao;
	
	@Test
	@Rollback(false)
	public void addOrder(){
		Order order = new Order();
		order.setStatus("ordering");
		
		Table t = null;
		t = tableDao.findOne((long) 50);
		order.setTable(t);
		
		orderDao.save(order);
		
	}
	
	
}
