package edu.nankai.cs.restaurant.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.nankai.cs.restaurant.entity.Menu;

public interface MenuDao extends PagingAndSortingRepository<Menu, Long> {
}
