package services;

import data.repositories.models.Offence;
import data.repositories.models.Officer;
import data.repositories.models.Ticket;
import data.repositories.models.Vehicle;

import java.util.List;

public interface TrafficService {
    Vehicle registerVehicle(Vehicle vehicleName);
    Officer registerOfficer(Officer officer);
    Ticket issueTicket(int vehicleId, Offence offence, int officerId);
    List<Ticket> viewTickets(int vehicleId);
    void payTicket(int ticketId);
    void addTicket(Ticket ticket);


}
