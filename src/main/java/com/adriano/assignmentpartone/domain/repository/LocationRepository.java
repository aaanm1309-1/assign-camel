package com.adriano.assignmentpartone.domain.repository;

import com.adriano.assignmentpartone.domain.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, String> {
    
}
