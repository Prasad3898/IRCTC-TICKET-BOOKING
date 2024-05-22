package com.prasad.service;

import org.springframework.stereotype.Service;

import com.prasad.request.Passenger;
import com.prasad.response.Ticket;

@Service
public interface BookingService {
	
	public Ticket bookTicket(Passenger passenger); 
	
	public Ticket getTicket(Integer ticketNumber);
	

}
