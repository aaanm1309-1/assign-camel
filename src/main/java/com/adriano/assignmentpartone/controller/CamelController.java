package com.adriano.assignmentpartone.controller;

import com.adriano.assignmentpartone.domain.entity.Client;
import com.adriano.assignmentpartone.domain.entity.Location;
import com.adriano.assignmentpartone.dto.BatchDTO;
import com.adriano.assignmentpartone.dto.EventDTO;
import com.adriano.assignmentpartone.service.EventService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CamelController extends RouteBuilder {

    @Autowired
    private EventService eventService;

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json);

        rest()
                .path("/batch")
                .post()
                .type(BatchDTO.class)
                .outType(ResponseEntity.class)
                .to("bean:batchEventPostBean");


        rest()
                .path("/events")
                .get()
                .produces("application/json")
                .outType(ResponseEntity.class)
                 .to("bean:eventGetAllBean")

                .post()
                .type(EventDTO.class)
                .outType(ResponseEntity.class)
                .to("bean:eventPostBean");

        rest()
                .path("/clients")
                .get()
                .produces("application/json")
                .outType(ResponseEntity.class)
                .to("bean:clientGetAllBean")

                .post()
                .type(Client.class)
                .outType(ResponseEntity.class)
                .to("bean:clientPostBean");

        rest()
                .path("/locations")
                .get()
                .produces("application/json")
                .outType(ResponseEntity.class)
                .to("bean:locationGetAllBean")

                .post()
                .type(Location.class)
                .outType(ResponseEntity.class)
                .to("bean:locationPostBean");


    }



}
