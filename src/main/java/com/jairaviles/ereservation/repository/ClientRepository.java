package com.jairaviles.ereservation.repository;

import com.jairaviles.ereservation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {
    /**
     * Retrieve clients by last name
     * @param last
     * @return List of Client
     */
    public List<Client> findByLast(String last);

    public Client findByUsername(String username);

}
