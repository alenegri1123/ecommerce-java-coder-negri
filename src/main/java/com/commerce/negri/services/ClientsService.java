package com.commerce.negri.services;

import com.commerce.negri.entities.Client;
import com.commerce.negri.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class ClientsService {
    @Autowired private ClientsRepository clientsRepository;

    //metodos para poder gestionar CRUD
    //Crear/Guardar cliente
    public Client registerClient(Client client) {
        return clientsRepository.save(client);
    }

    public Client updateClient(Long id, Client clientDetails) {
        Optional<Client> client = clientsRepository.findById(id);
        if (client.isPresent()) {
            Client foundClient = client.get();
            if (clientDetails.getName() != null) {
                foundClient.setName(clientDetails.getName());
            }
            if (clientDetails.getDocnumber() != null) {
                foundClient.setDocnumber(clientDetails.getDocnumber());
            }
            return clientsRepository.save(foundClient);
        } else {
            throw new RuntimeException("Client not found");
        }
    }

}
