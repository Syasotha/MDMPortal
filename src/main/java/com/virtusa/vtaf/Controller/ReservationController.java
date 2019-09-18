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
	private ReservationRepository resRepo;

	@PostMapping("/newreservation")
	public boolean addReservation(@RequestBody Reservation reservation) {
		System.out.println(reservation.getDeviceId());
		

		List<Reservation> reservations = resRepo.checkDeviceavailability(reservation.getDeviceId(),
				reservation.getStartTime(), reservation.getEndTime());

		if (reservations.isEmpty()) {

			return reservationService.addReservation(reservation);
		}

		return false;

	}

	@GetMapping("/reservation/{id}")
	public List<Reservation> getReservationbyUser(@PathVariable Integer id) {
		List<Reservation> reservation = resRepo.getReservationbyUser(id);

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

}
