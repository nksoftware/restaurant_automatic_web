package edu.nankai.cs.restaurant.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.nankai.cs.restaurant.entity.Reservation;

public interface ReservationDao extends PagingAndSortingRepository<Reservation, Long> {

}
