package com.jairaviles.ereservation.controllers;

import com.jairaviles.ereservation.json.ReservationVO;
import com.jairaviles.ereservation.model.Reservation;
import com.jairaviles.ereservation.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationVO reservationVO) {
        Reservation reservation = new Reservation();
        reservation.setDescription(reservationVO.getDescription());
        reservation.setStartDate(reservationVO.getStartDate());
        reservation.setEndDate(reservationVO.getEndDate());
        reservation.setTotalPeople(reservationVO.getTotalPeople());

        return new ResponseEntity<>(this.reservationService.create(reservation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") String idReservation, @RequestBody ReservationVO reservationVO) {
        Optional<Reservation> optional = this.reservationService.findById(idReservation);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Reservation reservation = optional.get();
            reservation.setDescription(reservationVO.getDescription());
            reservation.setStartDate(reservationVO.getStartDate());
            reservation.setEndDate(reservationVO.getEndDate());
            reservation.setTotalPeople(reservationVO.getTotalPeople());

            return new ResponseEntity<>(this.reservationService.create(reservation), HttpStatus.CREATED);
        }
    }
}
