package com.jairaviles.ereservation.controllers;

import com.jairaviles.ereservation.json.ClientVO;
import com.jairaviles.ereservation.model.Client;
import com.jairaviles.ereservation.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVO) {
        Client client = new Client();
        client.setFirst(clientVO.getFirst());
        client.setLast(clientVO.getLast());
        client.setAddress(clientVO.getAddress());
        client.setPhone(clientVO.getPhone());
        client.setEmail(clientVO.getEmail());

        return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
    }

    @PutMapping("/{username}")
    public ResponseEntity<Client> updateClient(@PathVariable("username") String username, @RequestBody ClientVO clientVO) {
        Client client = this.clientService.findByUsername(username);

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            client.setFirst(clientVO.getFirst());
            client.setLast(clientVO.getLast());
            client.setAddress(clientVO.getAddress());
            client.setPhone(clientVO.getPhone());
            client.setEmail(clientVO.getEmail());

            return new ResponseEntity<>(this.clientService.update(client), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> removeClient(@PathVariable("username") String username) {
        Client client = this.clientService.findByUsername(username);

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.clientService.delete(client);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(this.clientService.findAll());
    }
}
