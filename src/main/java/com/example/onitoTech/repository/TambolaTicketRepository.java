package com.example.onitoTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onitoTech.model.TambolaTicket;

@Repository
public interface TambolaTicketRepository extends JpaRepository<TambolaTicket, Long> {
  
}

