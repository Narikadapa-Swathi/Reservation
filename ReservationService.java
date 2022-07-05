package com.cg.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Reservation;
import com.cg.repository.ReservationRepository;

@Service
public class ReservationService{
	
	@Autowired
	private ReservationRepository reservationRepository;

	public Reservation addReservation(Reservation reservation) {
		reservationRepository.save(reservation);
		return reservation;
	}

	public Reservation updateReservation(int reservationId,String reservationType) {
		Reservation reservation=reservationRepository.findById(reservationId).get();
		reservation.setReservationType(reservationType);
		reservationRepository.deleteById(reservationId);
		reservationRepository.save(reservation);
		return reservation;
	}

	
	public Reservation deleteReservation(int reservationId) {
		
		Reservation reservation=reservationRepository.findById(reservationId).get();
		reservationRepository.deleteById(reservationId);
		return reservation;
	}


	public Reservation viewReservation(int reservationId) {
		
		Reservation reservation=reservationRepository.findById(reservationId).get();
		return reservation;
	}

	public List<Reservation> viewAllReservation() {
		
		return reservationRepository.findAll();
	
	}

	public List<Reservation> getAllReservation(LocalDate date) {
		
		return reservationRepository.findByReservationDate(date);
	}
	
}