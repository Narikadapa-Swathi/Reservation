package com.cg.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.dto.ReservationDto;
import com.cg.entity.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
	
	public List<ReservationDto> findAllByReservationDate(LocalDate date );
	
	
}
