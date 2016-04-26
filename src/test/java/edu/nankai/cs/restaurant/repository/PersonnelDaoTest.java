package edu.nankai.cs.restaurant.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import edu.nankai.cs.restaurant.entity.Personnel;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class PersonnelDaoTest  extends SpringTransactionalTestCase {
	
	@Autowired
	private PersonnelDao personnelDao;
	
	@Test
	@Rollback(false)
	public void addPersonnel(){
		Personnel p = new Personnel();
		
		p.setPersonnelJob("waiter");
		p.setPersonnelName("sbtl");
		p.setSalary((float) 1.0);
		
		personnelDao.save(p);
		
	}

}
