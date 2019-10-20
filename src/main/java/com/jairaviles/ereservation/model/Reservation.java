package com.jairaviles.ereservation.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid2")
    private String idReservation;
    private Date startDate;
    private Date endDate;
    private int totalPeople;
    private String description;
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;
}
