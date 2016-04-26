package edu.nankai.cs.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.nankai.cs.restaurant.entity.Schedule;

public interface ScheduleDao extends JpaRepository<Schedule, Schedule.PK>{
}
