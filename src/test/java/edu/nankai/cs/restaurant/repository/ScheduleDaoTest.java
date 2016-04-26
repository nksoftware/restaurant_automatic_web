package edu.nankai.cs.restaurant.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import edu.nankai.cs.restaurant.entity.Personnel;
import edu.nankai.cs.restaurant.entity.Schedule;
import edu.nankai.cs.restaurant.entity.Schedule.PK;
import edu.nankai.cs.restaurant.entity.Table;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ScheduleDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private ScheduleDao scheduleDao;
	@Autowired
	private PersonnelDao personnelDao;
	@Autowired
	private TableDao tableDao;
	
	@Test
	@Rollback(false)
	public void addSchedule(){
		Personnel waiter = personnelDao.findOne(100L);
		Table table = tableDao.findOne(800L);
		System.out.println(table);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null ;
		try {
			d = dateFormat.parse("2016-04-27");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Schedule schedule = new Schedule();
		
		schedule.setPk(new PK(waiter,table,d));
		schedule.setPeriod("morning");
		
		scheduleDao.save(schedule);
	}
	
}
