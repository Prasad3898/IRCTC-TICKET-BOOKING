package com.prasad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prasad.request.Passenger;
import com.prasad.response.Ticket;
import com.prasad.service.BookingService;

@RestController
public class BookingRestController {
	
	
    @Autowired
	private BookingService service;
	
	//Method to Book Ticket (POST)
	@PostMapping(value="/ticket",
			consumes= {"application/json"},
	        produces= {"application/json"})
	public ResponseEntity<Ticket> ticketBooking(@RequestBody Passenger passenger){
		
		System.out.println(passenger);
		Ticket ticket = service.bookTicket(passenger);
		
		
		return new ResponseEntity<>(ticket,HttpStatus.CREATED);
		
	}
	
	
	//Method to Get Ticket (GET)
	
	@GetMapping(value="/ticket/{ticketNum}",
	        produces= {"application/json"})
	
	public Ticket getTicketByNumber(@PathVariable Integer ticketNum) {
		
		return service.getTicket(ticketNum);
		
	}
	
	
	
	
	
	
	
}
