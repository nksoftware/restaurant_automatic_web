package edu.nankai.cs.restaurant.repository;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import edu.nankai.cs.restaurant.entity.Message;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class MessageDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private MessageDao messageDao;
	
	@Test
	@Rollback(false)
	public void addMessage(){
		Message m = new Message();
		m.setMessageDate(new Date());
		m.setDescription("lack meat");
		m.setMessageType("ingredients shortage");
		
		messageDao.save(m);
	}
	
	@Test
	public void findByDate(){
		List<Message> messages =  messageDao.findByMessageDate("2016-04-24");
		for(Message m : messages){
			System.out.println(m);
		}
	}
	
}
