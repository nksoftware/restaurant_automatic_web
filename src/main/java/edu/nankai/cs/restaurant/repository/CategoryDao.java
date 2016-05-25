package edu.nankai.cs.restaurant.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.nankai.cs.restaurant.entity.Category;

public interface CategoryDao extends CrudRepository<Category, Long> {
	List<Category> findAllByOrderByCategoryIdAsc();
}
