// BookingController.java
package com.example.bookingservice.controller;

import com.example.bookingservice.entity.BookingInfoEntity;
import com.example.bookingservice.repository.BookingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingInfoRepository bookingInfoRepository;

    @Autowired
    public BookingController(BookingInfoRepository bookingInfoRepository) {
        this.bookingInfoRepository = bookingInfoRepository;
    }

    // Endpoint 1 to collect booking information and save it in the database
    @PostMapping
    public ResponseEntity<BookingInfoEntity> createBooking(@RequestBody BookingInfoEntity bookingInfo) {
        // Simulate random room numbers between 1 and 100
        Random random = new Random();
        bookingInfo.setId(null);
        bookingInfo.setTransactionId(0); // 0 indicates no transaction made
        bookingInfo.setNumOfRooms(random.nextInt(100) + 1);

        // Save the booking information to the database
        BookingInfoEntity savedBooking = bookingInfoRepository.save(bookingInfo);

        // Return the saved booking in the response
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    // Other methods for handling additional requirements, if any
}
