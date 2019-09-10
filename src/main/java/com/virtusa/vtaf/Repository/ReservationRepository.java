package com.virtusa.vtaf.Repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.virtusa.vtaf.Model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	@Query(value = "SELECT * FROM reservation WHERE user_id = ?1", nativeQuery = true) // , nativeQuery = true
	List<Reservation> getReservationbyUser(int user_id);

	@Query(value = "SELECT * FROM reservation WHERE device_id=?1 AND 'startDateTime'BETWEEN start_time AND end_time OR 'enDateTime' BETWEEN start_time AND end_time", nativeQuery = true)
	List<Reservation> getReservationByDevice(int device_id, ZonedDateTime startDateTime, ZonedDateTime enDateTime);

}
