package com.virtusa.vtaf.Repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.virtusa.vtaf.Model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	@Query(value = "SELECT * FROM reservation WHERE user_id = ?1", nativeQuery = true)
	List<Reservation> getReservationbyUser(int user_id);

	@Query(value = "SELECT * FROM reservation WHERE device_id=?1 AND ?2 BETWEEN start_time AND end_time AND ?3 BETWEEN start_time AND end_time", nativeQuery = true)
	List<Reservation> checkDeviceavailability(Integer deviceId, ZonedDateTime startDateTime, ZonedDateTime endDateTime);

	@Query(value = "SELECT * FROM reservation WHERE device_id = ?1", nativeQuery = true)
	List<Reservation> getReservationbyDeviceID(int device_id);

}
