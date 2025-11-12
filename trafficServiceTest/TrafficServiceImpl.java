import data.models.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrafficServiceImpl {

    @Test
    void testRegisterAndIssueTicket() {
        TrafficService service = new TrafficService();

        Owner owner = new Owner("O1", "Chioma", "0903");
        Vehicle v = new Vehicle(1, "Toyota", "Corolla", "ABC-123", owner);
        service.registerVehicle(v);

        Officer officer = new Officer(1, "John", "Sergeant");
        service.registerOfficer(officer);

        Ticket t = service.issueTicket(1, Offence.NO_SEAT_BELT, 1);
        assertEquals(Offence.NO_SEAT_BELT, t.getOffence());
        assertFalse(t.isHasPaid());

        List<Ticket> list = service.viewTickets(1);
        assertEquals(1, list.size());
        assertEquals(t, list.get(0));
    }

    @Test
    void testPayTicket() {
        TrafficService service = new TrafficService();

        Owner owner = new Owner("O2", "James", "0902");
        Vehicle vehicle = new Vehicle(2, "Honda", "Civic", "XYZ-999", owner);
        service.registerVehicle(vehicle);

        Officer officer = new Officer(2, "Mike", "Corporal");
        service.registerOfficer(officer);

        Ticket ticket = service.issueTicket(2, Offence.OVER_SPEEDING, 2);
        service.payTicket(ticket.getId());
        assertTrue(ticket.isHasPaid());
    }
}
