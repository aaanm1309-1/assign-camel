package com.adriano.assignmentpartone.bean.location;

import com.adriano.assignmentpartone.domain.entity.Location;
import com.adriano.assignmentpartone.domain.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LocationPostBean {
    @Autowired
    private LocationRepository locationRepository;

    public ResponseEntity response(Location location) {

        return ResponseEntity.status(HttpStatus.OK).body( locationRepository.save(location) );
    }
}
