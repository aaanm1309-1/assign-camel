package com.adriano.assignmentpartone;

import com.adriano.assignmentpartone.domain.entity.Client;
import com.adriano.assignmentpartone.domain.entity.Event;
import com.adriano.assignmentpartone.domain.entity.Location;
import com.adriano.assignmentpartone.domain.repository.EventRepository;
import com.adriano.assignmentpartone.domain.repository.LocationRepository;
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
class LocationIntegrationIT {

	@Autowired
	private LocationRepository locationRepository;

	@Test
	public void testLocationMustSaveRepositoryWithSucess() {
		// Scenario
		Location location = new Location();
		location.setLocationId("I029");
		location.setLocationDescription("I029 description");

		//Action
		Location locationSave = locationRepository.save(location);

		//Validation
		Assertions.assertThat(locationSave).isNotNull();
		Assertions.assertThat(locationSave.getLocationId()).isNotNull();
	}

}
