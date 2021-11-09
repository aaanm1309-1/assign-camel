package com.adriano.assignmentpartone;

import com.adriano.assignmentpartone.domain.entity.Client;
import com.adriano.assignmentpartone.domain.entity.Event;
import com.adriano.assignmentpartone.domain.entity.Location;
import com.adriano.assignmentpartone.domain.repository.EventRepository;
import com.adriano.assignmentpartone.service.EventService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class EventIntegrationIT {
	@Autowired
	private EventService eventService;
	@Autowired
	private EventRepository eventRepository;

	@Test
	public void testEventMustSaveRepositoryWithSucess() {
		// Scenario
		Event event = new Event();
		event.setTransId("0000abf8-d1f5-4536-8fb0-36fe934b1f28");
		event.setTransTms(LocalDateTime.now());
		event.setTransTmsTimeZone("UTC");
		event.setRcNum("10002");
		event.setClient(new Client("RPS-00001","Willian client1"));
		event.setEventCnt(2L);
		event.setLocationCd("DESTINATION");
		List<Location> locations = new ArrayList<>();
		Location loc1 = new Location();
		loc1.setLocationId("T8C");
		Location loc2 = new Location();
		loc2.setLocationId("1J7");
		locations.add(loc1);
		locations.add(loc2);
		event.setLocations(locations);
		event.setAddrNbr("0000000001");

		//Action
		Event eventSave = eventRepository.save(event);

		//Validation
		Assertions.assertThat(eventSave).isNotNull();
		Assertions.assertThat(eventSave.getEventId()).isNotNull();
	}

}
