package com.jairaviles.ereservation.repository;

import com.jairaviles.ereservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
