package com.adriano.assignmentpartone.bean.event;

import com.adriano.assignmentpartone.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EventGetAllBean {
        @Autowired
        private EventService eventService;

        public ResponseEntity getAllEvents() {
//            // Your logic can go here! If you return a POJO, Camel will try and serialise it to JSON.
//            return ResponseEntity.status(HttpStatus.OK).body( "teste " );
            return ResponseEntity.status(HttpStatus.OK).body( eventService.listAlldto() );
        }


}
