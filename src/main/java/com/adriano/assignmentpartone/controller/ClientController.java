package com.adriano.assignmentpartone.controller;

import com.adriano.assignmentpartone.domain.entity.Client;
import com.adriano.assignmentpartone.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;


    @GetMapping
    public List<Client> listAll() {
        return clientRepository.findAll();
    }
    @PostMapping
    public Client save(@RequestBody Client client) {
        return clientRepository.save(client);
    }
}
