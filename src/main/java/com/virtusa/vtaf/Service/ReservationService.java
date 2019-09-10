package com.virtusa.vtaf.Service;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

import com.virtusa.vtaf.Model.Reservation;

public interface ReservationService {
	public List<Reservation> getAllReservation();

	public boolean addReservation(Reservation reservation);

	public Reservation getReservationById(Integer reservationId);

	// List<Reservation> getAllReservations();

	List<Reservation> getReservationByUser(int user_id);

	List<Reservation> getReservationByDevice(int device_id, ZonedDateTime startDateTime, ZonedDateTime enDateTime);

}
