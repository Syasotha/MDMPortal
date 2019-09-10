package com.virtusa.vtaf.Controller;

import java.time.ZonedDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.vtaf.Model.Reservation;
import com.virtusa.vtaf.Repository.ReservationRepository;
import com.virtusa.vtaf.Service.DeviceService;
import com.virtusa.vtaf.Service.ReservationService;

@RestController
public class ReservationController {
	@Autowired
	public ReservationService reservationService;
	@Autowired
	public DeviceService deviceService;

	@Autowired
	private ReservationRepository resDao;

	@PostMapping("/reservation")
	public HttpStatus addReservations(@Valid @RequestBody Reservation reservation) {

		boolean res = reservationService.addReservation(reservation);
		if (res) {

			return HttpStatus.ACCEPTED;
		}

		return HttpStatus.BAD_REQUEST;
	}

	@PostMapping("/newreservation")
	public boolean getEndTimebyDevice(@Valid @RequestBody Reservation reservation) {
		List<Reservation> reservations = reservationService.getReservationByDevice(reservation.getDeviceId(),reservation.getStartTime(),reservation.getEndTime());
		if (reservations.isEmpty()) {
			return false;
		}

		return reservationService.addReservation(reservation);

	}

	@GetMapping("/reservation/{id}")
	public List<Reservation> getReservationbyUser(@PathVariable Integer id) {
		List<Reservation> reservation = resDao.getReservationbyUser(id);

		if (reservation.isEmpty())
			throw new UserNotFoundException("id-" + id);

		return reservationService.getReservationByUser(id);

	}

	@GetMapping("/reservations")
	public ResponseEntity<List<Reservation>> getMobile() {
		List<Reservation> mobiles = reservationService.getAllReservation();

		ResponseEntity<List<Reservation>> response = new ResponseEntity<>(mobiles, HttpStatus.OK);
		return response;

	}

	@GetMapping("/reservations/{id}/startDateTime/enDateTime")
	public List<Reservation> getReservationbyDeviceId(@PathVariable Integer device_id, ZonedDateTime startDateTime,
			ZonedDateTime enDateTime) {
		List<Reservation> reservation = reservationService.getReservationByDevice(device_id, startDateTime, enDateTime);
		return reservation;

	}

}
