package edu.nankai.cs.restaurant.repository;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import edu.nankai.cs.restaurant.entity.Location;
import edu.nankai.cs.restaurant.entity.Reservation;
import edu.nankai.cs.restaurant.entity.Table;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TableDaoTest extends SpringTransactionalTestCase{

	@Autowired
	private TableDao tableDao;
	
	@Test
	@Rollback(false)
	public void addTable(){
		Table t = new Table();
		t.setPeopleNumber(10);
		
		Location loc = new Location();
		loc.setFloor(1);
		loc.setX((float) 1.0);
		loc.setY((float) 1.0);
		
		t.setLocation(loc);
		loc.setTable(t);
		
		tableDao.save(t);
	}
	
	@Test
	public void getReservations(){
		Table t = tableDao.findOne((long) 850);
		
		List<Reservation> reservations = t.getReservations();
		for(Reservation r : reservations){
			System.out.println(r);
		}
	}
	
	@Test
	public void getAll(){
		List<Table> tables = (List<Table>) tableDao.findByOrderByTableIdAsc();
		System.out.println(tables);
	}
	
	
	
}
