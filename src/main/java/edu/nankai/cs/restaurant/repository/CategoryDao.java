package edu.nankai.cs.restaurant.repository;

import org.springframework.data.repository.CrudRepository;

import edu.nankai.cs.restaurant.entity.Category;

public interface CategoryDao extends CrudRepository<Category, Long> {
}
