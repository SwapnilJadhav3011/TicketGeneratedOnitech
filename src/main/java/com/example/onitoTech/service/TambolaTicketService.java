package com.example.onitoTech.service;

import java.util.List;

import com.example.onitoTech.model.TambolaTicket;

public interface TambolaTicketService {

    List<TambolaTicket> generateAndSaveTickets(int numberOfSets);

    List<TambolaTicket> getAllTickets(int page, int size);
}

