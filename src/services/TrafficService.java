package services;

import data.models.Offence;
import data.models.Officer;
import data.models.Ticket;
import data.models.Vehicle;

import java.util.List;

public interface TrafficService {
    Vehicle registerVehicle(Vehicle vehicleName);
    Officer registerOfficer(Officer officer);
    Ticket issueTicket(int vehicleId, Offence offence, int officerId);
    List<Ticket> viewTickets(int vehicleId);
    void payTicket(int ticketId);

}
