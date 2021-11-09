package com.adriano.assignmentpartone.service;

import com.adriano.assignmentpartone.domain.entity.Client;
import com.adriano.assignmentpartone.domain.entity.Event;
import com.adriano.assignmentpartone.domain.entity.Location;
import com.adriano.assignmentpartone.domain.repository.ClientRepository;
import com.adriano.assignmentpartone.domain.repository.EventRepository;
import com.adriano.assignmentpartone.domain.repository.LocationRepository;
import com.adriano.assignmentpartone.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LocationRepository locationRepository;

    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .append(DateTimeFormatter.BASIC_ISO_DATE)
            .append(DateTimeFormatter.ofPattern("HHmmssSSS"))
            .appendPattern("z") // Zone
            .toFormatter();

    public ResponseEntity save(EventDTO eventDTO) {
        Client client = clientRepository.findById(eventDTO.getClientId()).orElse(new Client());
        if (client.getClientId() == null ) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Client ID not found");
        }
        Location location1 = null;
        Location location2 = null;

        if (eventDTO.getLocationId1()  != null) {
            location1 = locationRepository.findById(eventDTO.getLocationId1()).orElse(new Location());
            if (location1.getLocationId() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Location Id 1 not found");
            }
        } else {
            location1 = new Location();
        }
        if (eventDTO.getLocationId2() != null) {
            location2 = locationRepository.findById(eventDTO.getLocationId2()).orElse(new Location());
            if (location2.getLocationId() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Location Id 2 not found");
            }
        } else {
            location2 = new Location();
        }
        LocalDateTime dateTime;
        String timeZone;
        try {

            ZonedDateTime edt = ZonedDateTime.parse(eventDTO.getTransTms(), formatter);
            dateTime = edt.withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
            timeZone =  eventDTO.getTransTms().substring(eventDTO.getTransTms().length()-3);


        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Date/Time in transTMS");

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(
                transformEntityTODto(
                        eventRepository.save(transformDtoTOEntity(eventDTO, client, location1, location2, dateTime, timeZone))
                ));

    }

    public ResponseEntity listAll() {

        List<EventDTO> eventsDTO = eventRepository.findAll().stream().map(
                event -> {
                    return transformEntityTODto(event);
                }
        ).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(eventsDTO);
    }

    public List<EventDTO> listAlldto() {

        List<EventDTO> eventsDTO = eventRepository.findAll().stream().map(
                event -> {
                    return transformEntityTODto(event);
                }
        ).collect(Collectors.toList());

        return eventsDTO;
    }

    public Event transformDtoTOEntity(
            EventDTO eventDTO,
            Client client,
            Location location1,
            Location location2,
            LocalDateTime dateTime,
            String timeZone) {
        Event eventReturn = new Event();
        eventReturn.setTransId(eventDTO.getTransId());


        eventReturn.setTransTmsTimeZone(timeZone);

        eventReturn.setTransTms(dateTime);

        eventReturn.setRcNum(eventDTO.getRcNum());
        eventReturn.setClient(client);
        eventReturn.setEventCnt(eventDTO.getEventCnt());
        eventReturn.setLocationCd(eventDTO.getLocationCd());
        List<Location> locationList = new ArrayList<>();
        if (location1.getLocationId() != null) {
            locationList.add(location1);
        }
        if (location2.getLocationId() != null) {
            locationList.add(location2);
        }
        eventReturn.setLocations(locationList);
        eventReturn.setAddrNbr(eventDTO.getAddrNbr());

        return eventReturn;


    }

    public EventDTO transformEntityTODto(
            Event event) {
        EventDTO eventDTOReturn = new EventDTO();

        eventDTOReturn.setEventId(event.getEventId());
        eventDTOReturn.setTransId(event.getTransId());


        Integer diffHours = 0 ; //UTC
        if (event.getTransTmsTimeZone().equals("EDT")){
            diffHours = -4;
        }
        else if (event.getTransTmsTimeZone().equals("BET")){
            diffHours = -3;
        }
        else if (event.getTransTmsTimeZone().equals("EST")){
            diffHours = -4;
//            diffHours = -5;
        }

//        System.out.println(
//        event.getTransTms()
//                .atZone(ZoneId.of("UTC", ZoneId.SHORT_IDS))
//                .withZoneSameInstant(ZoneId.of("EDT", ZoneId.SHORT_IDS))
//        );

        String dateTime = event.getTransTms().plusHours(diffHours)
                .toString().substring(0,10).replace("-","");
        dateTime += event.getTransTms().plusHours(diffHours)
                .toString().substring(11,23).replace(":","").replace(".","");
        eventDTOReturn.setTransTms(dateTime);

        eventDTOReturn.setRcNum(event.getRcNum());

        eventDTOReturn.setClientId(event.getClient().getClientId());
        eventDTOReturn.setEventCnt(event.getEventCnt());
        eventDTOReturn.setLocationCd(event.getLocationCd());
        if (event.getLocations().size() > 1 ) {
            eventDTOReturn.setLocationId1(event.getLocations().get(0).getLocationId());
            if  (event.getLocations().size() > 2 ) {
                eventDTOReturn.setLocationId2(event.getLocations().get(1).getLocationId());
            }
        }
        eventDTOReturn.setAddrNbr(event.getAddrNbr());

        return eventDTOReturn;


    }

}
