package edu.nankai.cs.restaurant.repository;

import static org.assertj.core.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import edu.nankai.cs.restaurant.entity.Personnel;
import edu.nankai.cs.restaurant.entity.Schedule;
import edu.nankai.cs.restaurant.entity.Schedule.PK;
import edu.nankai.cs.restaurant.entity.Table;
import edu.nankai.cs.restaurant.web.util.DateUtil;

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
		Personnel waiter = personnelDao.findByLoginName("waiter");
		Table table = tableDao.findOne(1L);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse("2016-5-19");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date d = DateUtil.trimDate(date) ;
		
		Schedule schedule = new Schedule();
		
		schedule.setPk(new PK(waiter,table,d));
		schedule.setPeriod("morning");
		
		scheduleDao.save(schedule);
	}
	
	@Test
	public void getSchedule(){
		Date first = DateUtil.getThisWeekFirstDate();
		Date last = DateUtil.getNextWeekLastDate();
		
		List<Schedule> schedules = scheduleDao.findScheduleFromFirstToLast(first, last);
		
		System.out.println(schedules);
	}
	
	@Test
	public void getScheduleForWaiter(){
		Date date = new Date();
		List<Schedule> schedules = scheduleDao.findScheduleForWaiter("waiter", DateUtil.getStartOfDate(date), DateUtil.getEndOfDate(date));
		System.out.println(schedules);
		schedules = scheduleDao.findAll();
		System.out.println(schedules);
	}
	
}
