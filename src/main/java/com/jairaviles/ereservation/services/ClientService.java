package com.jairaviles.ereservation.services;

import com.jairaviles.ereservation.model.Client;
import com.jairaviles.ereservation.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Method that calls the save method from persistance layer
     * for creating a new client
     * @param client
     * @return Client client
     */
    @Transactional
    public Client create(Client client) {
        return this.clientRepository.save(client);
    }

    /**
     * Method that calls the save method from persistance layer
     * for updating an existing client
     * @param client
     * @return Client client
     */
    @Transactional
    public Client update(Client client) {
        return this.clientRepository.save(client);
    }

    /**
     * Method that calls the save method from persistance layer
     * for deleting an existing client
     * @param client
     * @return Client client
     */
    @Transactional
    public void delete(Client client) {
        this.clientRepository.delete(client);
    }

    /**
     * Gets a client by username
     * @param username
     * @return Client client
     */
    public Client findByUsername(String username) {
        return this.clientRepository.findByUsername(username);
    }

    public List<Client> findAll() {
        return this.clientRepository.findAll();
    }
}
