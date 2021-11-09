package com.adriano.assignmentpartone.bean.client;

import com.adriano.assignmentpartone.domain.entity.Client;
import com.adriano.assignmentpartone.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientPostBean {
    @Autowired
    private ClientRepository clientRepository;

    public ResponseEntity response( Client client) {

        return ResponseEntity.status(HttpStatus.OK).body( clientRepository.save(client) );
    }
}
