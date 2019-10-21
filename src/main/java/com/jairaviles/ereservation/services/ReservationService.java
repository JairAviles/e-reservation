package com.jairaviles.ereservation.services;

import com.jairaviles.ereservation.model.Reservation;
import com.jairaviles.ereservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public Reservation create(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    @Transactional
    public Reservation update(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    @Transactional
    public void delete(Reservation reservation) {
        this.reservationRepository.delete(reservation);
    }

    public List<Reservation> findByDateRange(Date startDate, Date endDate) {
        return this.reservationRepository.findByDateRange(startDate, endDate);
    }

    public Optional<Reservation> findById(String id) {
        return this.reservationRepository.findById(id);
    }
}
