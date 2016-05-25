package edu.nankai.cs.restaurant.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.nankai.cs.restaurant.entity.Table;

public interface TableDao extends PagingAndSortingRepository<Table, Long> {
	List<Table> findByOrderByTableIdAsc();
	
}
