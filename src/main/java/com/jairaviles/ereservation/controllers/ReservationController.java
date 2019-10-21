package com.jairaviles.ereservation.controllers;

import com.jairaviles.ereservation.json.ReservationVO;
import com.jairaviles.ereservation.model.Reservation;
import com.jairaviles.ereservation.services.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@Api(tags = "reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    @ApiOperation(value = "Create Reservation", notes = "Service for creating a new reservation")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Reservation created successfully"),
            @ApiResponse(code = 400, message = "Invalid request")})
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationVO reservationVO) {
        Reservation reservation = new Reservation();
        reservation.setDescription(reservationVO.getDescription());
        reservation.setStartDate(reservationVO.getStartDate());
        reservation.setEndDate(reservationVO.getEndDate());
        reservation.setTotalPeople(reservationVO.getTotalPeople());

        return new ResponseEntity<>(this.reservationService.create(reservation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Reservation", notes = "Service for updating an existing reservation by id")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Reservation updated successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 404, message = "Reservation not found")})
    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") String idReservation, @RequestBody ReservationVO reservationVO) {
        Reservation reservation = this.reservationService.findById(idReservation);
        if (reservation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            reservation.setDescription(reservationVO.getDescription());
            reservation.setStartDate(reservationVO.getStartDate());
            reservation.setEndDate(reservationVO.getEndDate());
            reservation.setTotalPeople(reservationVO.getTotalPeople());

            return new ResponseEntity<>(this.reservationService.create(reservation), HttpStatus.CREATED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> findReservationById(@PathVariable("id") String idReservation) {
        Reservation reservation = this.reservationService.findById(idReservation);
        if (reservation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(reservation);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Reservation", notes = "Service for deleting an existing reservation by id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Reservation deleted successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 404, message = "Reservation not found")})
    public ResponseEntity<String> removeClient(@PathVariable("id") String idReservation) {
        Reservation reservation = this.reservationService.findById(idReservation);

        if (reservation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.reservationService.delete(reservation);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping
    @ApiOperation(value = "List Reservations", notes = "Service for finding all existing reservations")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Reservation found"),
            @ApiResponse(code = 404, message = "Reservation not found")})
    public ResponseEntity<List<Reservation>> findAll() {
        return ResponseEntity.ok(this.reservationService.findAll());
    }
}
