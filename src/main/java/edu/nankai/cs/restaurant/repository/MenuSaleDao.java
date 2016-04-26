package edu.nankai.cs.restaurant.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.nankai.cs.restaurant.entity.MenuSale;

public interface MenuSaleDao extends PagingAndSortingRepository<MenuSale, MenuSale.PK> {
}
