package com.cg.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.ReservationDto;
import com.cg.entity.Reservation;
import com.cg.repository.ReservationRepository;

@Service
public class ReservationService{
	
	@Autowired
	private ReservationRepository reservationRepository;

	public Reservation addReservation(ReservationDto reservationDto) {
		Reservation reservation=new Reservation();
		BeanUtils.copyProperties(reservationDto, reservation);
		 reservationRepository.save(reservation);
		return reservation;
	}

	public ReservationDto updateReservation(int reservationId,String reservationType) {
		
		Reservation reservation=new Reservation();
		ReservationDto reservationDto=new ReservationDto();
		BeanUtils.copyProperties(reservationRepository.findById(reservationId).get(), reservationDto);
		
		reservationDto.setReservationType(reservationType);
		
		BeanUtils.copyProperties(reservationDto, reservation);
		reservationRepository.save(reservation);
		reservationRepository.flush();
		
		return reservationDto;
	}

	
	public Reservation deleteReservation(int reservationId) {
		ReservationDto reservationDto=new ReservationDto();
		Reservation reservation=new Reservation();
		reservationRepository.findById(reservationId).get();
		BeanUtils.copyProperties(reservationDto, reservation);
		reservationRepository.deleteById(reservationId);
		
		return reservation;
	}


	public ReservationDto viewReservation(int reservationId) {
		ReservationDto reservationDto=new ReservationDto();
		Reservation reservation=new Reservation();
		
		reservation=reservationRepository.findById(reservationId).get();
		BeanUtils.copyProperties(reservation, reservationDto);
		
		return reservationDto;
	}

	public List<ReservationDto> viewAllReservation() {
		List<ReservationDto> reservationDtoList=new ArrayList<>();
		List<Reservation> reservationList=reservationRepository.findAll();
		ReservationDto reservationDto=new ReservationDto();
		for(Reservation reservation:reservationList) {
			BeanUtils.copyProperties(reservation, reservationDto);
			reservationDtoList.add(reservationDto);
		}
		return reservationDtoList;
	
	}

	public List<ReservationDto> getAllReservation(LocalDate date) {
		ReservationDto reservationDto=new ReservationDto();
		Reservation reservation=new Reservation();
		
		return reservationRepository.findAllByReservationDate(date);
		
	}
	
}