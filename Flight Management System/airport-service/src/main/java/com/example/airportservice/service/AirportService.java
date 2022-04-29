package com.example.airportservice.service;

import java.util.List;

import com.example.airportservice.model.Airport;

public interface AirportService {

    public List<Airport> getAllAirports();

    public Airport getAirportByAirportId(long airportId);

    public List<Airport> getAirportByAirportName(String airportName);

    public List<Airport> getAirportByAirportModel(String airportCity);

    public List<Airport> setAllAirports(List<Airport> airports);

    public Airport setAirportDetails(Airport airport);

    public Airport updateAirportByAirportId(Airport airport);

    public void deleteAirportByAirportId(long airportId);

}
