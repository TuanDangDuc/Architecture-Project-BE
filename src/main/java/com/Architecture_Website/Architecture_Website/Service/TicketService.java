package com.Architecture_Website.Architecture_Website.Service;

import com.Architecture_Website.Architecture_Website.Model.TicketEntity;
import com.Architecture_Website.Architecture_Website.Repository.TicketRepository;
import com.Architecture_Website.Architecture_Website.Request.TicketRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketEntity createTicket(TicketRequest request) {
        TicketEntity ticket = TicketEntity.builder()
                .name(request.name())
                .area(request.area())
                .phone(request.phone())
                .budget(request.budget())
                .typeOfConsulting(request.typeOfConsulting())
                .timeReceipt(request.timeReceipt())
                .description(request.description())
                .build();
        return ticketRepository.save(ticket);
    }

    public List<TicketEntity> getAllTickets() {
        return ticketRepository.findAll();
    }

    public TicketEntity getTicketById(UUID id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public void deleteTicket(UUID id) {
        ticketRepository.deleteById(id);
    }

    public TicketEntity updateStatus(UUID id, String status) {
        TicketEntity ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.setStatus(status);
        return ticketRepository.save(ticket);
    }
}
