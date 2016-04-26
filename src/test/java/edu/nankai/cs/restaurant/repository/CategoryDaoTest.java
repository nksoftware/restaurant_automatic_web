package edu.nankai.cs.restaurant.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import edu.nankai.cs.restaurant.entity.Category;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class CategoryDaoTest extends SpringTransactionalTestCase {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Test
	@Rollback(false)
	public void addCategory(){
		Category c = new Category();
		c.setCategoryName("hot");
		
		categoryDao.save(c);
	}
	
}
