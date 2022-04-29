package com.example.airportservice.controller;

import java.util.List;

import com.example.airportservice.model.Airport;
import com.example.airportservice.service.AirportServiceImpl;
import com.example.airportservice.utility.GlobalResources;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private Logger logger = GlobalResources.getLogger(AirportController.class);
    
    // creating service object
    @Autowired
    private AirportServiceImpl airportServiceImpl;

    @GetMapping("/")
    public ResponseEntity<List<Airport>> getAllAirports() {
        try {
            return ResponseEntity.ok().body(airportServiceImpl.getAllAirports());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Controller for viewing a airport by ID

    @GetMapping("/{airportId}")
    public ResponseEntity<Airport> getAirportByAirportId(@PathVariable("airportId") long airportId) {
        try {
            return ResponseEntity.ok().body(airportServiceImpl.getAirportByAirportId(airportId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/Airport-Name")
    public ResponseEntity<List<Airport>> getAirportsByAirportName(@RequestParam("airportName") String airportName) {
        try {
            return ResponseEntity.ok().body(airportServiceImpl.getAirportByAirportName(airportName));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Controller for adding airport
    
    @PostMapping("/")
    public ResponseEntity<String> setAirports(@RequestBody Airport airport) {
        try {
            airportServiceImpl.setAirportDetails(airport);
            return ResponseEntity.ok().body("Airport Details Added Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/All-Airports")
    public ResponseEntity<String> setAllAirports(@RequestBody List<Airport> airports) {
        try {

            airportServiceImpl.setAllAirports(airports);
            return ResponseEntity.ok().body("All Airport Details Are Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Controller for modifying existing airport

    @PutMapping("/update/{airportId}")
    public ResponseEntity<Airport> updateAirportById(@PathVariable("airportId") long airportId,
            @RequestBody Airport airport) {
        try {
            List<Airport> airports = airportServiceImpl.getAllAirports();
            boolean flag = false;
            for (Airport a : airports) {
                if (a.getAirportId() == airportId) {
                    flag = true;
                    airportServiceImpl.updateAirportByAirportId(airport);
                }
            }

            if (flag == false) {
                throw new Exception();
            }
            return ResponseEntity.ok().body(airport);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Controller for deleting existing airport

    @DeleteMapping("/delete/{airportId}")
    public ResponseEntity<String> deleteAirportById(@PathVariable("airportId") long airportId) {
        try {
            List<Airport> airports = airportServiceImpl.getAllAirports();
            boolean flag = false;
            for (Airport a : airports) {
                if (a.getAirportId() == airportId) {
                    flag = true;
                    airportServiceImpl.deleteAirportByAirportId(airportId);
                }
            }

            if (flag == false) {
                throw new Exception();
            }
            return ResponseEntity.ok().body("Airport Details Deleted Successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Airport Details Not Found!!");
        }
    }
}
