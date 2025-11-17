package data.repositories.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketsTest {

    private Owner owner;
    private Vehicle vehicle;
    private Officer officer;

    @BeforeEach
    void setUp() {

        Owner owner = new Owner(1, "Alice Johnson", "09060099538");

        vehicle = new Vehicle(1, "Toyota", "Camry", owner);


        officer = new Officer(1, "James Bond", "twoStar");
    }

    @Test
    void testTicketInitialization() {
        Ticket ticket = new Ticket(vehicle, Offence.OVER_SPEEDING, officer);

        assertNotNull(ticket);
        assertEquals(vehicle, ticket.getVehicle());
        assertEquals(Offence.OVER_SPEEDING, ticket.getOffence());
        assertEquals(officer, ticket.getOfficer());
        assertFalse(ticket.isPaid());
    }

    @Test
    void testIdAutoIncrements() {
        Ticket ticket1 = new Ticket(vehicle, Offence.OVER_SPEEDING, officer);
        Ticket ticket2 = new Ticket(vehicle, Offence.DRUNK_DRIVING, officer);

        assertEquals(ticket1.getId() + 1, ticket2.getId());
    }

    @Test
    void testPayMarksTicketAsPaid() {
        Ticket ticket = new Ticket(vehicle, Offence.OVER_SPEEDING, officer);

        assertFalse(ticket.isPaid());
        ticket.pay();
        assertTrue(ticket.isPaid());
    }

    @Test
    void testSettersWork() {
        Ticket ticket = new Ticket(vehicle, Offence.OVER_SPEEDING, officer);
        Owner owner = new Owner(1, "Alice Johnson", "09060099538");
        Vehicle Vehicle = new Vehicle(1, "Toyota", "Camry", owner);
        Officer officer = new Officer(1, "James Bond", "twoStar");

        ticket.setVehicle(Vehicle);
        ticket.setOffence(Offence.DRUNK_DRIVING);
        ticket.setOfficer(officer);

        assertEquals(Vehicle, ticket.getVehicle());
        assertEquals(Offence.DRUNK_DRIVING, ticket.getOffence());
        assertEquals(officer, ticket.getOfficer());
    }
}
