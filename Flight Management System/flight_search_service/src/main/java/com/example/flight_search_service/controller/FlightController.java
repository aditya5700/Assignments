package com.example.flight_search_service.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.flight_search_service.classes.FlightDetails;
import com.example.flight_search_service.model.Flight;
import com.example.flight_search_service.services.FlightServiceImpl;
import com.example.flight_search_service.utility.GlobalResources;
import com.fasterxml.jackson.annotation.JsonFormat;

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
@RequestMapping("/api/flights")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {

    private Logger logger = GlobalResources.getLogger(FlightController.class);
    
    @Autowired
    private FlightServiceImpl flightServiceImpl;

    @GetMapping(value = "/")
    public ResponseEntity<List<Flight>> getAllFlights() {
        try {
            return ResponseEntity.ok().body(flightServiceImpl.getAllFlights());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/flightDetails")
    public ResponseEntity<List<FlightDetails>> getAllFlightDetials() {
        try {
            return ResponseEntity.ok().body(flightServiceImpl.getAllFlightDetails());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/source-to-destination")
    public ResponseEntity<List<FlightDetails>> getFlightDetailsBetweenSourceAndDestination(
            @RequestParam("sourceAirportCity") String sourceAirportCity,
            @RequestParam("destinationAirportCity") String destinationAirportCity) {
        try {
            return ResponseEntity.ok().body(
                    flightServiceImpl.getFlightsBetweenSourceAndDestination(sourceAirportCity, destinationAirportCity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/flightDetails/{id}")
    public ResponseEntity<FlightDetails> getFlightDetailsByFlightId(@PathVariable("id") long id) {
        try {
            return ResponseEntity.ok().body(flightServiceImpl.getFlightDetailsById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/source-to-destination-with-departure")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public ResponseEntity<List<FlightDetails>> getFlightDetailsBwSourceAndDestinationAndDepartureDate(
            @RequestParam("sourceAirportCity") String sourceAirportCity,
            @RequestParam("destinationAirportCity") String destinationAirportCity,
            @RequestParam("departureDate") String departureDate) {
        try {

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(departureDate, dateTimeFormatter);
            return ResponseEntity.ok().body(flightServiceImpl.getFlightBwSourceAndDestinationAndDepartureDate(
                    sourceAirportCity, destinationAirportCity, localDate));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> setFlightDetails(@RequestBody Flight flight) {
        try {
            flightServiceImpl.setFlight(flight);
            return ResponseEntity.ok().body("FLight Details Added Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
        }
    }
}
