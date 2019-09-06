package com.virtusa.vtaf.Service;

import java.util.List;

import com.virtusa.vtaf.Model.Reservation;

public interface ReservationService {
	public List<Reservation> getAllReservation();

	public boolean addReservation(Reservation reservation);

	public Reservation getReservationById(Integer reservationId);
	
	//List<Reservation> getAllReservations();

	List<Reservation> getReservationByUser(int user_id);

}
