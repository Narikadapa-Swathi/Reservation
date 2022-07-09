package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.ReservationDto;
import com.cg.entity.Reservation;
import com.cg.serviceimpl.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	public ReservationService reservationService;
	
	
	@PostMapping
	public Reservation addReservation(@RequestBody ReservationDto reservationDto) {
		return reservationService.addReservation(reservationDto);
	}
	
	@PatchMapping("/{reservationId}/{reservationType}")
	public ReservationDto updateReservation(@PathVariable ("reservationId") int reservationId,@PathVariable("reservationType") String reservationType) {
		return  reservationService.updateReservation(reservationId, reservationType);
	}
	
	@DeleteMapping("/{reservationId}")
	public Reservation deleteReservation(@PathVariable ("reservationId") int reservationId) {
		return  reservationService.deleteReservation(reservationId);
	}
	
	@GetMapping("/{reservationId}")
	public ReservationDto viewReservation(@PathVariable("reservationId") int reservationId) {
		return  reservationService.viewReservation(reservationId);
	}
	
	@GetMapping("/viewAll")
	public List<ReservationDto> viewAllReservation(){
		return  reservationService.viewAllReservation();
	}
	
	@PostMapping("/{date}")
	public List<ReservationDto> findByReservationDate(@PathVariable ("date") LocalDate date){
		return  reservationService.getAllReservation(date);
	}

}
