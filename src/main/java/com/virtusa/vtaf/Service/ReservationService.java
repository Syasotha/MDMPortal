package com.virtusa.vtaf.Service;

import java.time.ZonedDateTime;
import java.util.List;

import com.virtusa.vtaf.Model.Reservation;

public interface ReservationService {
	public List<Reservation> getAllReservation();

	public boolean addReservation(Reservation reservation);

	List<Reservation> getReservationByUser(int user_id);

	List<Reservation> checkDeviceavailability(int device_id, ZonedDateTime startDateTime, ZonedDateTime enDateTime);

}
