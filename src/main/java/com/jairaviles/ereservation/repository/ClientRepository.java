package com.jairaviles.ereservation.repository;

import com.jairaviles.ereservation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    /**
     * Retrieve clients by last name
     * @param last
     * @return List of Client
     */
    public List<Client> findByLast(String last);

    public Client findByUsername(String username);

}
