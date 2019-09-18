package com.virtusa.vtaf.test;

import java.time.ZonedDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class test {
	 @Autowired
	 //private ReservationRepository reservationRepository;
	 
	 @Test
		public void testFindTheGreatestFromAllData(ZonedDateTime startDateTime, ZonedDateTime enDateTime) {
	  
	   
		 
	  //reservationRepository.checkDeviceavailability(1, startDateTime, enDateTime);
	 }
	 
	
}
