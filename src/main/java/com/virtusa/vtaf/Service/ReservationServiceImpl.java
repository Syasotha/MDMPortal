package com.virtusa.vtaf.Service;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;
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
		return false;
	}

	@Override
	public List<Reservation> getAllReservation() {
		return reservationRepository.findAll();

	}

	@Override
	public Reservation getReservationById(Integer reservationId) {
		return reservationRepository.getOne(reservationId);

	}

	@Override
	public List<Reservation> getReservationByUser(int user_id) {
		// TODO Auto-generated method stub
		return reservationRepository.getReservationbyUser(user_id);
	}

	@Override
	public List<Reservation> getReservationByDevice(int device_id, ZonedDateTime startDateTime,
			ZonedDateTime enDateTime) {
		return reservationRepository.getReservationByDevice(device_id, startDateTime, enDateTime);
	}

}
