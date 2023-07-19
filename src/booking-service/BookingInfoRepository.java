// BookingInfoRepository.java
package com.example.bookingservice.repository;

import com.example.bookingservice.entity.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingInfoRepository extends JpaRepository<BookingInfoEntity, Long> {
}
