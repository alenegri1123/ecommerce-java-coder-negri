package com.commerce.negri.services;

import com.commerce.negri.entities.Client;
import com.commerce.negri.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClientsService {
    @Autowired private ClientsRepository repository;

    //metodos para poder gestionar CRUD
    //Crear/Guardar cliente
    public Client save(Client client) {
        return repository.save(client);
    }

    //leer todos los clientes
    public List<Client> read() {
        return repository.findAll();
    }

    //Buscar 1 cliente
    private Optional<Client> readOne(Long id) {
        return repository.findById(id);
    }

    //Eliminar un cliente
    public void deleteOne(Long id) {
        repository.deleteById(id);
    }

}
