package com.adriano.assignmentpartone.controller;

import com.adriano.assignmentpartone.dto.EventDTO;
import com.adriano.assignmentpartone.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/event")
public class EventController {


    @Autowired
    private EventService eventService;


    @GetMapping
    public ResponseEntity listAll() {
        return eventService.listAll();
    }
    @PostMapping
    public ResponseEntity save(@RequestBody EventDTO eventDTO) {
        return eventService.save(eventDTO);
    }
}
