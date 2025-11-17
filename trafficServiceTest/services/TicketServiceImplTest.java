package services;

import data.repositories.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketServiceImplTest {

    private TicketService ticketService;
    private Ticket ticket1;
    private Ticket ticket2;

    @BeforeEach
    void setUp() {
        ticketService = new TicketServiceImpl();

        Owner owner = new Owner(1, "John", "Smith");
        Officer officer = new Officer(2, "Delight", "Smith");
        Vehicle myVehicle = new Vehicle(1, "Toyota", "AAX2025", owner);

        ticket1 = new Ticket(myVehicle, Offence.OVER_SPEEDING, officer);
        ticket2 = new Ticket(myVehicle, Offence.DRUNK_DRIVING, officer);
    }

    @Test
    void testAddTicket() {
        ticketService.addTicket(ticket1);
        List<Ticket> tickets = ticketService.getAllTickets();

        assertEquals(1, tickets.size());
        assertTrue(tickets.contains(ticket1));
    }

    @Test
    void testViewTicket() {
        ticketService.addTicket(ticket1);
        ticketService.addTicket(ticket2);

        Ticket found = ticketService.viewTicket(2);  // id should be 2

        assertEquals(ticket2, found);
    }

    @Test
    void testViewTicket_NotFound() {
        ticketService.addTicket(ticket1);

        assertThrows(IllegalArgumentException.class,
                () -> ticketService.viewTicket(50));
    }

    @Test
    void testSettleTicket() {
        ticketService.addTicket(ticket1);

        ticketService.settleTicket(1);

        assertTrue(ticket1.isPaid());
    }

    @Test
    void testSettleTicket_AlreadyPaid() {
        ticketService.addTicket(ticket1);
        ticketService.settleTicket(1);

        assertThrows(IllegalStateException.class,
                () -> ticketService.settleTicket(1));
    }

    @Test
    void testGetAllTickets() {
        ticketService.addTicket(ticket1);
        ticketService.addTicket(ticket2);

        List<Ticket> tickets = ticketService.getAllTickets();

        assertEquals(2, tickets.size());
        assertTrue(tickets.contains(ticket1));
        assertTrue(tickets.contains(ticket2));
    }

    @Test
    void testRemoveTicket() {
        ticketService.addTicket(ticket1);
        ticketService.addTicket(ticket2);

        ticketService.removeTicket(1);

        List<Ticket> all = ticketService.getAllTickets();
        assertEquals(1, all.size());
        assertFalse(all.contains(ticket1));
    }

    @Test
    void testRemoveTicket_NotFound() {
        ticketService.addTicket(ticket1);

        assertThrows(IllegalArgumentException.class,
                () -> ticketService.removeTicket(99));
    }
}
