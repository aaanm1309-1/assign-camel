package com.adriano.assignmentpartone.bean.client;

import com.adriano.assignmentpartone.domain.repository.ClientRepository;
import com.adriano.assignmentpartone.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientGetAllBean {
        @Autowired
        private ClientRepository clientRepository;

        public ResponseEntity getAllClients() {
            return ResponseEntity.status(HttpStatus.OK).body( clientRepository.findAll() );
        }


}
