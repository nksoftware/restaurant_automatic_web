package edu.nankai.cs.restaurant.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.nankai.cs.restaurant.entity.AccountItem;

public interface AccountItemDao extends PagingAndSortingRepository<AccountItem, Long> {
}
