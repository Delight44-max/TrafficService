package services;
import data.repositories.models.Offence;
import data.repositories.models.Officer;
import data.repositories.models.Ticket;
import data.repositories.models.Vehicle;

import java.util.ArrayList;
import java.util.List;
public class TrafficServiceImpl implements TrafficService {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Officer> officers = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public Vehicle registerVehicle(Vehicle vehicleName) {
        vehicles.add(vehicleName);
        return vehicleName;
    }

    @Override
    public Officer registerOfficer(Officer officer) {
        officers.add(officer);
        return officer;
    }

    @Override
    public Ticket issueTicket(int vehicleId, Offence offence, int officerId) {
        Vehicle foundVehicle = null;
        Officer foundOfficer = null;


        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == vehicleId) {
                foundVehicle = vehicle;
                break;
            }
        }


        for (Officer officer : officers) {
            if (officer.getId() == officerId) {
                foundOfficer = officer;
                break;
            }
        }

        if (foundVehicle == null || foundOfficer == null) {
            throw new RuntimeException("data.models.Vehicle or officer not found");
        }


        Ticket ticket = new Ticket(foundVehicle, offence, foundOfficer);
        foundVehicle.addTicket(ticket);
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public List<Ticket> viewTickets(int vehicleId) {
        List<Ticket> result = new ArrayList<>();

        for (Ticket ticket : tickets) {
            if (ticket.getVehicle().getId() == vehicleId) {
                result.add(ticket);
            }
        }

        return result;
    }

    @Override
    public void payTicket(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == ticketId) {
                ticket.pay();
                break;
            }
        }
    }

    @Override
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);

    }

}

