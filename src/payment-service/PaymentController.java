// PaymentController.java
package com.example.bookingservice.controller;

import com.example.bookingservice.entity.BookingInfoEntity;
import com.example.bookingservice.repository.BookingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class PaymentController {

    private final BookingInfoRepository bookingInfoRepository;

    @Autowired
    public PaymentController(BookingInfoRepository bookingInfoRepository) {
        this.bookingInfoRepository = bookingInfoRepository;
    }

    // Endpoint 2 to take payment details and save the transactionId in the booking table
    @PostMapping("/{bookingId}/transaction")
    public ResponseEntity<BookingInfoEntity> processPayment(
            @PathVariable Long bookingId,
            @RequestParam String paymentMode,
            @RequestParam(required = false) String upiId,
            @RequestParam(required = false) String cardNumber
    ) {
        BookingInfoEntity bookingInfo = bookingInfoRepository.findById(bookingId).orElse(null);

        if (bookingInfo == null) {
            return new ResponseEntity<>("Invalid Booking Id", HttpStatus.BAD_REQUEST);
        }

        if (!paymentMode.equals("UPI") && !paymentMode.equals("CARD")) {
            return new ResponseEntity<>("Invalid mode of payment", HttpStatus.BAD_REQUEST);
        }

        // Assuming you have a payment service that processes payments and returns a transactionId
        // For demonstration purposes, we will use a dummy transactionId
        int transactionId = 12345;

        // Update the booking with the received transactionId
        bookingInfo.setTransactionId(transactionId);
        bookingInfoRepository.save(bookingInfo);

        return new ResponseEntity<>(bookingInfo, HttpStatus.CREATED);
    }

    // Other methods for handling additional requirements, if any
}
