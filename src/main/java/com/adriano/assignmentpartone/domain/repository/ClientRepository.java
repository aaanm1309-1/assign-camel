package com.adriano.assignmentpartone.domain.repository;

import com.adriano.assignmentpartone.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, String> {
    
}
