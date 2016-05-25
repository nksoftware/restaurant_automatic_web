package edu.nankai.cs.restaurant.repository;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import edu.nankai.cs.restaurant.entity.Category;
import edu.nankai.cs.restaurant.entity.Menu;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class MenuDaoTest extends SpringTransactionalTestCase{
	
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private CategoryDao categoryDao;
 	
	@Test
	@Rollback(false)
	public void addMenu(){
		try {
			Menu m = new Menu();
			m.setDishName("红烧肉");
			m.setImage("nopic");
			m.setPrice((float) 12.3);
			m.setUpdatetime(new Date());
			m.setDescription("肉很多");
			Category c = categoryDao.findOne((long) 1);
			m.setCategory(c);
			menuDao.save(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void getMenu(){
		Menu menu = menuDao.findByDishName("红烧鱼");
		System.out.println(menu);
	}
}
