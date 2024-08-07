package com.commerce.negri.controllers;


import com.commerce.negri.entities.Client;
import com.commerce.negri.services.ClientsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path ="api/v1/auth/register")
@Tag(name= "Clients Route", description= "Clients CRUD")
public class ClientsController {

    @Autowired
    private ClientsService clientsServices;

    PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody Client data) {
        try {
            Client client = clientsServices.saveClient(data);
            return new ResponseEntity<>(client, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Error de registro");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> readClient(PathVariable Integer id) {
        try {
            Optional<Client> clients = clientsServices.readOne(id);
            if (clients.isPresent()) {
                return ResponseEntity.ok(clients.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    GetMapping
    public ResponseEntity



}
