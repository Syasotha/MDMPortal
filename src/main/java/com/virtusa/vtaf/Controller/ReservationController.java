package com.virtusa.vtaf.Controller;

import java.time.LocalTime;
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

	@PostMapping("/reservation1")
	public boolean addReservations1(@Valid @RequestBody Reservation reservation, @PathVariable Integer reservationId) {

		Integer deviceId = reservationService.getReservationById(reservationId).getDeviceId();
		LocalTime endTime = reservationService.getReservationById(reservationId).getEndTime();

		LocalTime time = LocalTime.now();

		if (time.equals(endTime)) {
			return reservationService.addReservation(reservation);
		}
		return false;

	}

	// @SuppressWarnings("unlikely-arg-type")
	// @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
	@GetMapping("/reservation/{id}")
	public List<Reservation> getReservationbyUser(@PathVariable Integer id ) {
		return null;
		
		

		/*List<Reservation> resByUser = reservationService.getReservationbyUser(user_id);
		if ((resByUser.get(user_id)).equals(id)) {
			return resByUser;
		} else {
			throw new UserNotFoundException();
		}*/

		// return resDao.getReservationbyUser(user_id).orElseThrow(() -> new
		// UserNotFoundException(user_id));

	}

	@GetMapping("/reservations")
	public ResponseEntity<List<Reservation>> getMobile() {
		List<Reservation> mobiles = reservationService.getAllReservation();

		ResponseEntity<List<Reservation>> response = new ResponseEntity<>(mobiles, HttpStatus.OK);
		return response;

	}
}
