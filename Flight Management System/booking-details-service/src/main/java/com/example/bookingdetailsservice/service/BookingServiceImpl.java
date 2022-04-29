package com.example.bookingdetailsservice.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

import com.example.bookingdetailsservice.model.Booking;
import com.example.bookingdetailsservice.repository.BookingRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Override
    public List<Booking> getAllBookings() {

        return bookingRepo.findAll();
    }

    @Override
    public List<Booking> getAllBookingByUsername(String username) {

        return bookingRepo.findByUsername(username);
    }

    @Override
    public Booking setBookingDetails(Booking booking) {

        if (booking != null) {
            char[] chars = new char[] {
                    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                    'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                    'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2',
                    '3', '4', '5', '6', '7', '8', '9' };

            Random rnd = new Random();
            int charslength = chars.length;
            int passLenght = 10;
            String ticketGenerated = new String();

            for (int i = 0; i < passLenght; i++) {
                int index = rnd.nextInt(charslength - i - 1);
                char a = chars[i + index];
                chars[i + index] = chars[i];
                chars[i] = a;
                ticketGenerated += a;
            }

            booking.setTicketId(ticketGenerated);

            LocalDate date = LocalDate.now();
            booking.setBookingDate(date);

            LocalTime time = LocalTime.now();
            booking.setBookingTime(time);

            bookingRepo.save(booking);
        }

        return booking;
    }

    @Override
    public Booking updateBookingById(Booking booking) {

        return bookingRepo.save(booking);
    }

    @Override
    public void deletBookingByUsername(String ticketId) {

        bookingRepo.deleteByTicketId(ticketId);

    }

    @Override
    public Booking getBookingByTicketId(String ticketId) {

        return bookingRepo.findByTicketId(ticketId);
    }

}
