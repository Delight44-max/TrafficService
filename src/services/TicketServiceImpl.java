package services;

import data.repositories.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketServiceImpl implements TicketService {

    private List<Ticket> tickets = new ArrayList<>();
    private int ticketIdCounter = 1;

    @Override
    public void addTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null");
        }

        ticket.setId(ticketIdCounter++);
        tickets.add(ticket);
    }

    @Override
    public Ticket viewTicket(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        throw new IllegalArgumentException("Ticket with ID " + id + " not found");
    }

    @Override
    public void settleTicket(int id) {
        Ticket ticket = viewTicket(id);
        if (ticket.isPaid()) {
            throw new IllegalStateException("Ticket is already settled");
        }
        ticket.setPaid(true);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return new ArrayList<>(tickets);
    }

    @Override
    public void removeTicket(int id) {
        Ticket found = null;

        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                found = ticket;
                break;
            }
        }

        if (found == null) {
            throw new IllegalArgumentException("Cannot remove. Ticket with ID " + id + " not found");
        }

        tickets.remove(found);
    }
}
