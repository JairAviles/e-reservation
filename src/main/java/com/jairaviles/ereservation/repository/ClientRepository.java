package com.jairaviles.ereservation.repository;

import com.jairaviles.ereservation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
    Client findByUsername(String username);
}
