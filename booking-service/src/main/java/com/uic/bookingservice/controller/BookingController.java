package com.uic.bookingservice.controller;

import com.uic.bookingservice.collection.Booking;
import com.uic.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBooking();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable String id) {
        return bookingService.getBookingById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBookingById(@PathVariable String id) {
        bookingService.deleteBooking(id);
    }

    @PutMapping
    public void updateBooking(@RequestBody Booking booking, @PathVariable String id) {
        bookingService.updateBooking(booking,id);
    }
}
