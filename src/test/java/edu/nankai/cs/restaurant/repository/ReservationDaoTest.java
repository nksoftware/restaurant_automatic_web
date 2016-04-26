package edu.nankai.cs.restaurant.repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import edu.nankai.cs.restaurant.entity.Reservation;
import edu.nankai.cs.restaurant.entity.Table;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ReservationDaoTest extends SpringTransactionalTestCase{
	
	@Autowired
	private ReservationDao reservationDao;
	@Autowired
	private TableDao tableDao;
	
	@Test
	@Rollback(false)
	public void addReservation(){
		List<Table> tables = (List<Table>) tableDao.findAll();
		Table table = tables.get(0);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = null;
		Date end = null;
		try {
			start = dateFormat.parse("2016-04-25 11:00:00");
			end = dateFormat.parse("2016-04-25 12:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Reservation reservation = new Reservation();
		reservation.setTable(table);
		reservation.setCustomerName("sbtl");
		reservation.setCustomerTelephone("18222278799");
		reservation.setEndtime(end);
		reservation.setStarttime(start);
		reservation.setPeopleNumber(10);
		
		reservationDao.save(reservation);
	}
	
}
