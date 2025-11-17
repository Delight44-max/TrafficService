package data.repositories.repositories;

import data.repositories.models.Ticket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tickets implements TicketRepositories {

    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public Ticket save(Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    @Override
    public List<Ticket> findAll() {
        if (tickets.isEmpty()) {
            throw new RuntimeException("No tickets found");
        }
        return tickets;
    }

    @Override
    public void deleteById(int id) {
        if (tickets.isEmpty()) {
            throw new RuntimeException("No tickets to delete");
        }

        Iterator<Ticket> iterator = tickets.iterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            if (ticket.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public void delete(Ticket ticketToDelete) {
        if (tickets.isEmpty()) {
            throw new RuntimeException("No tickets to delete");
        }

        Iterator<Ticket> iterator = tickets.iterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            if (ticket.equals(ticketToDelete)) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public void deleteAll() {
        tickets.clear();
    }

    @Override
    public long count() {
        return tickets.size();
    }
}
