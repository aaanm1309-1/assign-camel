package com.adriano.assignmentpartone.domain.repository;

import com.adriano.assignmentpartone.domain.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {

}
