package com.virtusa.vtaf.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.vtaf.Model.Reservation;
import com.virtusa.vtaf.Service.ReservationService;

@RestController
public class ReservationController {

	@Autowired
	public ReservationService reservationService;

	@PostMapping("/newreservation")
	public boolean Controller(@RequestBody Reservation reservation) throws Exception {

		List<Reservation> reservations = reservationService.checkDeviceavailability(reservation.getDeviceId(),
				reservation.getStartTime(), reservation.getEndTime());

		if (reservations.isEmpty()) {

			return reservationService.addReservation(reservation);

		}
		throw new Exception();

	}

	@GetMapping("/reservation/{id}")
	public List<Reservation> getReservationbyUser(@PathVariable Integer id) {
		List<Reservation> reservation = reservationService.getReservationByUser(id);

		if (reservation.isEmpty())
			throw new UserNotFoundException("That user is not avilable---" + id);

		return reservation;

	}

	@GetMapping("/reservationByDeviceId/{device_id}")
	public List<Reservation> getReservationByDeviceId(@PathVariable Integer device_id) {
		List<Reservation> reservation = reservationService.getReservationByDeviceId(device_id);

		if (reservation.isEmpty())
			throw new UserNotFoundException("That Device is not avilable ---" + device_id);

		return reservation;

	}

	@GetMapping("/reservations")
	public ResponseEntity<List<Reservation>> getAllReservation() {
		List<Reservation> mobiles = reservationService.getAllReservation();

		ResponseEntity<List<Reservation>> response = new ResponseEntity<>(mobiles, HttpStatus.OK);
		return response;

	}

}
