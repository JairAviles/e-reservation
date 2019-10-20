package com.jairaviles.ereservation.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid2")
    private String idClient;
    private String first;
    private String last;
    @Column(unique = true)
    private String username;
    private String address;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "client")
    private Set<Reservation> reservations;

}
