package com.virtusa.vtaf.Service;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.vtaf.Model.Reservation;
import com.virtusa.vtaf.Repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	public ReservationRepository reservationRepository;

	@Override
	public boolean addReservation(Reservation reservation) {
		reservationRepository.save(reservation);
		return reservation != null;
	}

	@Override
	public List<Reservation> getAllReservation() {
		return reservationRepository.findAll();

	}


	@Override
	public List<Reservation> getReservationByUser(int user_id) {
		// TODO Auto-generated method stub
		return reservationRepository.getReservationbyUser(user_id);
	}

	@Override
	public List<Reservation> checkDeviceavailability(int device_id, ZonedDateTime startDateTime,
			ZonedDateTime enDateTime) {
		return reservationRepository.checkDeviceavailability(device_id, startDateTime, enDateTime);

	}

}
