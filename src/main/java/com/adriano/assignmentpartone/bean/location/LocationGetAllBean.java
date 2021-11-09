package com.adriano.assignmentpartone.bean.location;

import com.adriano.assignmentpartone.domain.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LocationGetAllBean {
        @Autowired
        private LocationRepository locationRepository;

        public ResponseEntity getAllClients() {
            return ResponseEntity.status(HttpStatus.OK).body( locationRepository.findAll() );
        }


}
