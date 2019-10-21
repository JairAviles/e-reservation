package com.jairaviles.ereservation.json;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationVO {
    private String idReservation;
    private Date startDate;
    private Date endDate;
    private int totalPeople;
    private String description;
}
