package services;

import data.repositories.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrafficServiceImplTest {

    private TrafficService trafficService;

    @BeforeEach
    void setUp() {
        trafficService = new TrafficServiceImpl();
    }

    @Test
    void testRegisterVehicle() {
        Owner owner = new Owner(1, "John Doe", "08012345678");

        Vehicle vehicle = new Vehicle(1, "ABC123", "Toyota", owner);
        Vehicle saved = trafficService.registerVehicle(vehicle);

        assertEquals(vehicle, saved);
    }

    @Test
    void testRegisterOfficer() {
        Officer officer = new Officer(1, "James Bond", "FiveStar");
        Officer saved = trafficService.registerOfficer(officer);

        assertEquals(officer, saved);
    }

    @Test
    void testIssueTicket() {
        Owner owner = new Owner(1, "John Doe", "08012345678");

        Vehicle vehicle = new Vehicle(1, "ABC123", "Toyota", owner);
        Officer officer = new Officer(1, "James Bond", "FiveStar");
        Offence offence = Offence.OVER_SPEEDING;

        trafficService.registerVehicle(vehicle);
        trafficService.registerOfficer(officer);

        Ticket ticket = trafficService.issueTicket(1, offence, 1);

        assertNotNull(ticket);
        assertEquals(vehicle, ticket.getVehicle());
        assertEquals(offence, ticket.getOffence());
        assertEquals(officer, ticket.getOfficer());
    }

    @Test
    void testIssueTicketVehicleNotFound() {
        Officer officer = new Officer(1, "James Bond",  "FiveStar");
        Offence offence = Offence.OVER_SPEEDING;

        trafficService.registerOfficer(officer);

        assertThrows(RuntimeException.class, () ->
                trafficService.issueTicket(999, offence, 1));
    }

    @Test
    void testViewTickets() {
        Owner owner = new Owner(1, "John Doe", "08012345678");
        Vehicle vehicle = new Vehicle(1, "ABC123", "Toyota",owner );
        Officer officer = new Officer(1, "James Bond", "FiveStar");
        Offence offence = Offence.OVER_SPEEDING;

        trafficService.registerVehicle(vehicle);
        trafficService.registerOfficer(officer);

        Ticket ticket1 = trafficService.issueTicket(1, offence, 1);
        Ticket ticket2 = trafficService.issueTicket(1, offence, 1);

        List<Ticket> tickets = trafficService.viewTickets(1);

        assertEquals(2, tickets.size());
        assertTrue(tickets.contains(ticket1));
        assertTrue(tickets.contains(ticket2));
    }

    @Test
    void testPayTicket() {
        Owner owner = new Owner(1, "John Doe", "08012345678");
        Vehicle vehicle = new Vehicle(1, "ABC123", "Toyota", owner);
        Officer officer = new Officer(1, "James Bond", "FiveStar");
        Offence offence = Offence.OVER_SPEEDING;

        trafficService.registerVehicle(vehicle);
        trafficService.registerOfficer(officer);

        Ticket ticket = trafficService.issueTicket(1, offence, 1);


        assertDoesNotThrow(() -> trafficService.payTicket(ticket.getId()));
    }

    @Test
    void testAddTicket() {
        Owner owner = new Owner(1, "John Doe", "08012345678");
        Vehicle vehicle = new Vehicle(1, "ABC123", "Toyota", owner);
        Officer officer = new Officer(1, "James Bond", "FiveStar");
        Offence offence = Offence.OVER_SPEEDING;

        Ticket ticket = new Ticket(vehicle, offence, officer);

        assertDoesNotThrow(() -> trafficService.addTicket(ticket));
    }
}
