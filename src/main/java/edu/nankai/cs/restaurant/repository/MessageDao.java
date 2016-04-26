package edu.nankai.cs.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.nankai.cs.restaurant.entity.Message;

public interface MessageDao extends PagingAndSortingRepository<Message, Long> {
	@Query(value="select m from Message m where to_char(m.messageDate,'yyyy-mm-dd') = ?1" )
	public List<Message> findByMessageDate(String date);
	
}
