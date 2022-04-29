package com.example.airportservice.repository;

import java.util.List;

import com.example.airportservice.model.Airport;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepo extends MongoRepository<Airport, Long> {

    public Airport findByAirportId(long airportId);

    public List<Airport> findByAirportCity(String airportCity);

    public List<Airport> findByAirportName(String airportName);

    public Airport findByAirportNameAndAirportCity(String airportName, String airportCity);
}
