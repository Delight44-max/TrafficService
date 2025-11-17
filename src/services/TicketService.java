package services;

import data.repositories.models.Ticket;
import java.util.List;

public interface TicketService {

    void addTicket(Ticket ticket);

    Ticket viewTicket(int id);

    List<Ticket> getAllTickets();

    void removeTicket(int id);

    void settleTicket(int id);
}
