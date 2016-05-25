package edu.nankai.cs.restaurant.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.nankai.cs.restaurant.entity.Personnel;
import edu.nankai.cs.restaurant.entity.Schedule;

public interface ScheduleDao extends JpaRepository<Schedule, Schedule.PK>{
	
	@Query("select s from Schedule s where s.pk.workDate between ?1 and ?2")
	List<Schedule> findScheduleFromFirstToLast(Date first, Date last);
	
	@Query("select s from Schedule s where s.pk.waiter.loginName = ?1 and s.pk.workDate between ?2 and ?3")
	List<Schedule> findScheduleForWaiter(String loginName, Date dateStart, Date dateEnd);
	
}
