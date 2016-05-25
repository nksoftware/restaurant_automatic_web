package edu.nankai.cs.restaurant.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.nankai.cs.restaurant.entity.Menu;

public interface MenuDao extends PagingAndSortingRepository<Menu, Long> {
	List<Menu> findAllByOrderByDishIdAsc();
	
	Menu findByDishName(String dishName);
}
