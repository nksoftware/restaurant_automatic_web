package edu.nankai.cs.restaurant.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.nankai.cs.restaurant.entity.Personnel;

public interface PersonnelDao extends PagingAndSortingRepository<Personnel, Long> {
	Personnel findByLoginName(String loginName);
}
