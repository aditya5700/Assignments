package com.example.bookingdetailsservice.controller;

import java.util.List;

import com.example.bookingdetailsservice.exception.TicketAlreadyBookedException;
import com.example.bookingdetailsservice.model.Booking;
import com.example.bookingdetailsservice.service.BookingServiceImpl;
import com.example.bookingdetailsservice.service.SequenceGeneratorService;
import com.example.bookingdetailsservice.utility.GlobalResources;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

    private Logger logger = GlobalResources.getLogger(BookingController.class);

    @Autowired
    private BookingServiceImpl bookingServiceImpl;

    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/")
    public ResponseEntity<List<Booking>> getAllBookings() {

        try {
            return ResponseEntity.ok().body(bookingServiceImpl.getAllBookings());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/getByUsername")
    public ResponseEntity<List<Booking>> getBookingByUsername(@RequestParam("username") String username) {
        try {
            return ResponseEntity.ok().body(bookingServiceImpl.getAllBookingByUsername(username));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<String> setBookingDetails(@RequestBody Booking booking) {

        try {
            if (booking.getTicketId() != null) {
                throw new TicketAlreadyBookedException("You have already booked the ticket");
            } else {
                booking.setBookingId(service.getSequenceNumber(Booking.SEQUENCE_NAME));
                bookingServiceImpl.setBookingDetails(booking);

                return ResponseEntity.ok().body(booking.getTicketId());
            }

        } catch (TicketAlreadyBookedException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Booking Details Cannot Be Null!!");
        }

    }

    @GetMapping("/getByTicketId/{ticketId}")
    public ResponseEntity<Booking> getBookingByTicketId(@PathVariable("ticketId") String ticketId) {
        try {
            return ResponseEntity.ok().body(bookingServiceImpl.getBookingByTicketId(ticketId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
