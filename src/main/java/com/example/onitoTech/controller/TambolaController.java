package com.example.onitoTech.controller;
import com.example.onitoTech.model.TambolaTicket;
import com.example.onitoTech.service.TambolaTicketService;

import jakarta.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/tambola")
public class TambolaController {

    private static final Logger logger = LoggerFactory.getLogger(TambolaController.class);

    @Autowired
    private TambolaTicketService ticketService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateAndSaveTickets(@RequestParam @Min(1) int numberOfSets) {
        try {
            List<TambolaTicket> generatedTickets = ticketService.generateAndSaveTickets(numberOfSets);
            logger.info("{} Tambola ticket(s) generated and saved successfully.", numberOfSets);
            return new ResponseEntity<>(generatedTickets, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error generating tickets: {}", e.getMessage());
            return new ResponseEntity<>("Error generating tickets: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<TambolaTicket>> getAllTickets(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size) {
        try {
            List<TambolaTicket> tickets = ticketService.getAllTickets(page, size);
            logger.info("Retrieved {} Tambola ticket(s) successfully.", tickets.size());
            return new ResponseEntity<>(tickets, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error retrieving tickets: {}", e.getMessage());
            return new ResponseEntity<>("Error retrieving tickets: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}

