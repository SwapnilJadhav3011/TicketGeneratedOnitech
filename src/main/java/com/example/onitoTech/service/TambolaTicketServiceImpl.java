package com.example.onitoTech.service;



import com.example.onitoTech.model.TambolaTicket;
import com.example.onitoTech.repository.TambolaTicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TambolaTicketServiceImpl implements TambolaTicketService {

    private static final Logger logger = LoggerFactory.getLogger(TambolaTicketServiceImpl.class);

    @Autowired
    private TambolaTicketRepository ticketRepository;

    @Override
    public List<TambolaTicket> generateAndSaveTickets(int numberOfSets) {
        List<TambolaTicket> generatedTickets = new ArrayList<>();
        try {
            for (int i = 0; i < numberOfSets; i++) {
                TambolaTicket ticket = generateTicket();
                ticketRepository.save(ticket);
                generatedTickets.add(ticket);
            }
            logger.info("{} Tambola ticket(s) generated and saved successfully.", numberOfSets);
        } catch (Exception e) {
            logger.error("Error generating and saving tickets: {}", e.getMessage());
            // Optionally, you can rethrow or handle the exception as needed
        }
        return generatedTickets;
    }

    @Override
    public List<TambolaTicket> getAllTickets(int page, int size) {
        try {
            List<TambolaTicket> tickets = ticketRepository.findAll();
            logger.info("Retrieved {} Tambola ticket(s) successfully.", tickets.size());
            return tickets;
        } catch (Exception e) {
            logger.error("Error retrieving tickets: {}", e.getMessage());
           
            return new ArrayList<>();
        }
    }



    private TambolaTicket generateTicket() {
       
        TambolaTicket ticket = new TambolaTicket();
        
        return ticket;
    }
}


