package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Reservation;
import com.cg.service.ReservationService;

@RestController

public class ReservationController {
	@Autowired
	public ReservationService reservationService;
	
	@RequestMapping("/reservation")
	
	@PostMapping("/{reservation}")
	public Reservation addReservation(@RequestBody Reservation reservation) {
		return reservationService.addReservation(reservation);
	}
	
	@PutMapping("/{reservationId}/{reservationType}")
	public Reservation updateReservation(@PathVariable ("reservationId") int reservationId,@PathVariable("reservationType") String reservationType) {
		return  reservationService.updateReservation(reservationId, reservationType);
	}
	
	@DeleteMapping("/{reservationId}")
	public Reservation deleteReservation(@PathVariable ("reservationId") int reservationId) {
		return  reservationService.deleteReservation(reservationId);
	}
	
	@GetMapping("/{reservationId}")
	public Reservation viewReservation(@PathVariable("reservationId") int reservationId) {
		return  reservationService.viewReservation(reservationId);
	}
	
	@GetMapping("/viewAllReservation/")
	public List<Reservation> viewAllReservation(){
		return  reservationService.viewAllReservation();
	}
	
	@GetMapping("/{date}")
	public List<Reservation> findByReservationDate(@PathVariable ("date") LocalDate date){
		return  reservationService.getAllReservation(date);
	}

}
