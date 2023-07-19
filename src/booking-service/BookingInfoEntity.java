// BookingInfoEntity.java
package com.example.bookingservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BookingInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fromDate;
    private Date toDate;
    private String aadharNumber;
    private int numOfRooms;
    private int transactionId; // 0 indicates no transaction made

    // Constructors, getters, setters, and other methods (if needed) go here
}
