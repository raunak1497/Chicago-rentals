package com.uic.bookingservice.service;

import com.uic.bookingservice.collection.Booking;

import java.util.List;


public interface BookingService {
    Booking createBooking(Booking booking);

    List<Booking> getAllBooking();

    Booking getBookingById(String id);

    void deleteBooking(String id);

    void updateBooking(Booking booking, String id);
}
