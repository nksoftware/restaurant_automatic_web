package edu.nankai.cs.restaurant.repository;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import edu.nankai.cs.restaurant.entity.Menu;
import edu.nankai.cs.restaurant.entity.MenuSale;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class MenuSaleDaoTest extends SpringTransactionalTestCase{

	@Autowired
	private MenuSaleDao menuSaleDao;
	@Autowired
	private MenuDao menuDao;
	
	@Test
	public void findSaleByDate(){
		//fault
		Menu m = menuDao.findOne(150L);
		MenuSale menuSale = menuSaleDao.findOne(new MenuSale.PK(m,new Date()));
		System.out.println(menuSale);
	}
}
