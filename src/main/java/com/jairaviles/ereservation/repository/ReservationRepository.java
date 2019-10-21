package com.jairaviles.ereservation.repository;

import com.jairaviles.ereservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
    public Reservation findByIdReservation(String idReservation);

    @Query("select r from Reservation r where r.startDate =:startDate and r.endDate =:endDate")
    public List<Reservation> findByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
