package com.example.angularspring.repositories;

import com.example.angularspring.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {



}
