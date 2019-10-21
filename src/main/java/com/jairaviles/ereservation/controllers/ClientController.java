package com.jairaviles.ereservation.controllers;

import com.jairaviles.ereservation.json.ClientVO;
import com.jairaviles.ereservation.model.Client;
import com.jairaviles.ereservation.services.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientController {
    private final ClientService clientService;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @ApiOperation(value = "Create Client", notes = "Service for creating a new client")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Client created successfully"),
                            @ApiResponse(code = 400, message = "Invalid request")})
    public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVO) {
        Client client = new Client();
        client.setFirst(clientVO.getFirst());
        client.setLast(clientVO.getLast());
        client.setAddress(clientVO.getAddress());
        client.setPhone(clientVO.getPhone());
        client.setEmail(clientVO.getEmail());
        client.setUsername(clientVO.getUsername());

        return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
    }

    @PutMapping("/{username}")
    @ApiOperation(value = "Update Client", notes = "Service for updating an existing client by username")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Client updated successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 404, message = "Client not found")})
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
            client.setUsername(clientVO.getUsername());

            return new ResponseEntity<>(this.clientService.update(client), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{username}")
    @ApiOperation(value = "Delete Client", notes = "Service for deleting an existing client by username")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Client deleted successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 404, message = "Client not found")})
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
    @ApiOperation(value = "List Clients", notes = "Service for finding all existing clients")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Clients found"),
            @ApiResponse(code = 404, message = "Clients not found")})
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(this.clientService.findAll());
    }
}
