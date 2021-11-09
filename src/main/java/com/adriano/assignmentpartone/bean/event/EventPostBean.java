package com.adriano.assignmentpartone.bean.event;


import com.adriano.assignmentpartone.dto.EventDTO;
import com.adriano.assignmentpartone.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EventPostBean {
    @Autowired
    private EventService eventService;
    public ResponseEntity response(EventDTO input) {
        return ResponseEntity.status(HttpStatus.OK).body( eventService.save(input) );
    }
}
