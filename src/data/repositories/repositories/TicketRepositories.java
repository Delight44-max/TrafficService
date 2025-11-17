package data.repositories.repositories;

import data.repositories.models.Ticket;

import java.util.List;

public interface TicketRepositories {

    Ticket save(Ticket ticket);

    Ticket findById(int id);

    List<Ticket> findAll();

    void deleteById(int id);

    void delete(Ticket ticket);

    void deleteAll();

    long count();
}
