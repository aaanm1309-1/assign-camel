package com.adriano.assignmentpartone.service;

import com.adriano.assignmentpartone.dto.BatchDTO;
import com.adriano.assignmentpartone.dto.EventDTO;
import com.adriano.assignmentpartone.dto.EventNewDTO;
import com.adriano.assignmentpartone.dto.RecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatchEventService {

    @Autowired
    public EventService eventService;


    public ResponseEntity save(BatchDTO batchDTO) {
        List<EventDTO> listFinalEvent = new ArrayList<>();
        for (RecordDTO rec:
             batchDTO.getRecords()) {
            for (EventNewDTO event:
                 rec.getEvent()) {
                EventDTO eventFinal = new EventDTO();
                eventFinal.setTransId(rec.getTransId());
                eventFinal.setTransTms(rec.getTransTms());
                eventFinal.setRcNum(rec.getRcNum());
                eventFinal.setClientId(rec.getClientId());
                eventFinal.setEventCnt(event.getEventCnt());
                eventFinal.setLocationCd(event.getLocationCd());
                eventFinal.setLocationId1(event.getLocationId1());
                eventFinal.setLocationId2(event.getLocationId2());
                eventFinal.setAddrNbr(event.getAddrNbr());
                eventService.save(eventFinal);
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(
                " Batch information included."
                );
    }

}


