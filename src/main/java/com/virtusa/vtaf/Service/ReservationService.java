package com.virtusa.vtaf.Service;

import java.time.ZonedDateTime;
import java.util.List;

import com.virtusa.vtaf.Model.Reservation;

public interface ReservationService {

	public List<Reservation> getAllReservation();

	public boolean addReservation(Reservation reservation);

	public List<Reservation> getReservationByUser(int user_id);

	public List<Reservation> checkDeviceavailability(Integer deviceId, ZonedDateTime startDateTime,
			ZonedDateTime enDateTime);

	public List<Reservation> getReservationByDeviceId(int device_id);

}
